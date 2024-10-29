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
    //********************************************************
    public PersonEntity getDataBydId(Long id){
        return personRepository.findById(id).orElse(null);
    }
    public PersonEntity updateData(PersonEntity data){
        return personRepository.save((PersonEntity) data);
    }
    //*********************************************************
    public List<PersonEntity> postPersons(List<PersonEntity> personEntities){
        return personRepository.saveAll(personEntities);
    }
    //*********************************************************
    public void deletePersons(Long id){
        personRepository.deleteById(id);
    }
}
