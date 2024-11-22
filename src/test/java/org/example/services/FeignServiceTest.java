package org.example.services;

import org.example.clients.PersonClient;
import org.example.entities.PersonEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class FeignServiceTest {
    @Mock
    public PersonClient personClient;
    @InjectMocks
    public FeignService feignService;
    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }
    @Test
    @DisplayName("Проверка колличества персон")
    public void testGetPersons(){
        //Подготовка данных
        List<PersonEntity> mockPersons = Collections.singletonList(new PersonEntity());
        when(personClient.getPerson()).thenReturn(mockPersons);

        Object result = feignService.getPersons();
        assertEquals(1L,result);
    }
}