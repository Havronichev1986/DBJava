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

    public List<PersonEntity> getPersons(List<Long> ids){
        if (ids == null){
            return personRepository.findAll();
        }else {
            return personRepository.findAllById(ids);
        }
    }
    public List<PersonEntity> createPersons(List<PersonEntity> personEntities){
        return personRepository.saveAll(personEntities);
    }

    public List<PersonEntity> deletePersons(List<Long> ids) {
        List<PersonEntity> personEntities = personRepository.findAllById(ids);
        personRepository.deleteAll(personEntities);
        return personEntities;
    }
}
