package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DBService {
    private final PersonRepository personRepository;

    public List<PersonEntity> getPersons(){
        return personRepository.findAll();
    }
}
