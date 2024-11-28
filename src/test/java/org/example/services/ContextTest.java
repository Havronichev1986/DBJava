package org.example.services;

import org.example.entities.PersonEntity;
import org.example.repositories.PersonRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
public class ContextTest {
    @Autowired
    DBService dbService;
    @Autowired
    PersonRepository personRepository;
    static List<PersonEntity> personEntities = new ArrayList<>();
    static {
        personEntities.add(new PersonEntity(1L,"Василий",(short)34));
        personEntities.add(new PersonEntity(2L,"Петр",(short)38));
        personEntities.add(new PersonEntity(3L,"Олег",(short)33));
        personEntities.add(new PersonEntity(4L,"Светлана",(short)32));
        personEntities.add(new PersonEntity(5L,"Наталья",(short)31));
        personEntities.add(new PersonEntity(6L,"Оксана",(short)37));
        personEntities.add(new PersonEntity(7L,"Вадим",(short)23));
        personEntities.add(new PersonEntity(8L,"Мария",(short)32));
        personEntities.add(new PersonEntity(9L,"Александр",(short)54));
        personEntities.add(new PersonEntity(10L,"Евгений",(short)65));
    }
    static final List<Long> ids = List.of(1L, 2L);
    

    static Stream<List<Long>> parameters(){return  Stream.of(ids,null);}

    Iterator<PersonEntity> personEntityIterator = personEntities.stream().iterator();

    @BeforeEach
    void setUp(){
        personRepository.saveAll(personEntities);
    }
    @AfterEach
    void setDown(){
        personRepository.deleteAll();
    }
    @Test
    @DisplayName("Проверка БД")
    void context(){
//        Iterator<PersonEntity> personEntityIterator = personEntities.stream().iterator();
        assertThat(personRepository.findAll()).allMatch(personEntity -> CollectionUtils.contains(personEntityIterator,personEntity));
    }
    @DisplayName("Получение персон")
    @ParameterizedTest(name = "{index} - {0} is a palindrome")
    @MethodSource("parameters")
    void getPersons(List<Long> ids){
//        Iterator<PersonEntity> personEntityIterator = personEntities.stream().iterator();
        assertThat(dbService.getPersons(ids)).allMatch(personEntity -> CollectionUtils.contains(personEntityIterator,personEntity));
    }
    @Test
    @DisplayName("Создание персон")
    void createPersons(){
//        Iterator<PersonEntity> personEntityIterator = personEntities.stream().iterator();
        assertThat(dbService.createPersons(personEntities)).allMatch(personEntity -> CollectionUtils.contains(personEntityIterator,personEntity));
    }

    @Test
    @DisplayName("Удаление персон")
    void deletePersons(){
//        Iterator<PersonEntity> personEntityIterator = personEntities.stream().iterator();
        assertThat(dbService.deletePersons(ids)).allMatch(personEntity -> CollectionUtils.contains(personEntityIterator,personEntity));
    }
}
