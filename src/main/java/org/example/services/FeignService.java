package org.example.services;

import lombok.extern.slf4j.Slf4j;
import org.example.clients.PersonClient;
import org.example.entities.PersonEntity;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.List;

@Service
@Slf4j
public class FeignService {
    private final PersonClient personClient;

    public FeignService(PersonClient personClient) {
        this.personClient = personClient;
    }
    @SuppressWarnings("unchecked")
    public Object getPersons(){
        log.info("Вычесление колличечтва персон");
        return (long) ((List<PersonEntity>) personClient.getPerson()).size();
    }
}
