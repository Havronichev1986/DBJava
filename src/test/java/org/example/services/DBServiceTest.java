package org.example.services;


import lombok.extern.slf4j.Slf4j;
import org.example.entities.PersonEntity;
import org.example.repositories.PersonRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;
import static org.mockito.Mockito.when;

@Slf4j
@ExtendWith(MockitoExtension.class)

public class DBServiceTest {
    @InjectMocks
    DBService dbService;
    @Mock
    PersonRepository personRepository;

    @Test
    @DisplayName("Тест getPersons")
    //Подготовка тестов данных
    void getPersons(){
        var ids = List.of(1L,2L);
        var personEntities1 = List.of(new PersonEntity(1L,"Василий",(short)20));
        var personEntities2 = List.of(new PersonEntity(2L,"Петр",(short)35));
        when(personRepository.findAllById(ids)).thenReturn(personEntities1);
        when(personRepository.findAll()).thenReturn(personEntities2);
        //Тест
        List<PersonEntity> personEntitiesA = dbService.getPersons(ids);
        List<PersonEntity> personEntitiesB = dbService.getPersons(null);
        log.info("A: {}" , personEntitiesA);
        log.info("B: {}" , personEntitiesB);
        log.info("1: {}" , personEntities1);
        log.info("2: {}" , personEntities2);
        //проверка результатов
        assertThat(personEntitiesA).isEqualTo(personEntities1);
        assertThat(personEntitiesB).isEqualTo(personEntities2);
    }

    @Test
    @DisplayName("Тест createPersons")
    void createPersons(){
        var personEntities1 = List.of(new PersonEntity(1L,"Василий",(short)20));
        // Подготовка мока для метода save
        when(personRepository.saveAll(personEntities1)).thenReturn(personEntities1);
        //Test
        List<PersonEntity> createdPersons = dbService.createPersons(personEntities1);

        //Проверка результата
        assertThat(createdPersons).isEqualTo(personEntities1);

    }
    @Test
    void deletePersons(){
        var ids = List.of(1L,2L);
        var personEntities1 = List.of(new PersonEntity(1L,"Василий",(short)20));
        var personEntities2 = List.of(new PersonEntity(2L,"Петр",(short)35));
        when(personRepository.findAllById(ids)).thenReturn(personEntities1);
        List<PersonEntity> personEntities = dbService.deletePersons(ids);
        assertThat(personEntities).isEqualTo(personEntities1);
    }
}
