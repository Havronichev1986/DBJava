package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.example.entities.PersonEntity;
import org.example.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.assertj.core.api.InstanceOfAssertFactories.STREAM;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)

public class DBServiceTest {
    @InjectMocks
    DBService dbService;
    @Mock
    PersonRepository personRepository;

    private static final List<Long> ids = List.of(1L,2L);
    private static final List<PersonEntity> personEntities1 = List.of(new PersonEntity(1L,"Василий",(short)20));

    @BeforeEach
    void setUp(){
        lenient().when(personRepository.findAllById(ids)).thenReturn(personEntities1);
        lenient().when(personRepository.findAll()).thenReturn(personEntities1);
        lenient().when(personRepository.saveAll(personEntities1)).thenReturn(personEntities1);
    }

    public static Stream<List<Long>> parameters(){
        return Stream.of(ids,null);
    }


    @DisplayName("Получние персон")
    @ParameterizedTest(name = "{index} - {0} is a palindrome")
    @MethodSource("parameters")
    //Подготовка тестов данных
    void getPersons(List<Long>ids){
        //Тест
        List<PersonEntity> personEntitiesA = dbService.getPersons(ids);
        log.info("A: {}" , personEntitiesA);
        log.info("1: {}" , personEntities1);
        //проверка результатов
        assertThat(personEntitiesA).isEqualTo(personEntities1);
    }

    @Test
    @DisplayName("Создание персон")
    void createPersons(){
        List<PersonEntity> personEntities = dbService.createPersons(personEntities1);
        assertThat(personEntities).isEqualTo(personEntities1);
    }
    @Test
    @DisplayName("Удаление персон")
    void deletePersons(){
        List<PersonEntity> personEntities = dbService.deletePersons(ids);
        assertThat(personEntities).isEqualTo(personEntities1);
    }
}
