package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.dtos.TemplateDto;
import org.example.dtos.TimeDto;
import org.example.entities.PersonEntity;
import org.example.mappers.PersonMapper;
import org.example.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DBService {
    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

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
    public TemplateDto getPerson(){
        PersonEntity personEntity = personRepository.findAll().stream().findAny().orElse(new PersonEntity(15L,"Василий", (short)35));
        return personMapper.map(personEntity, new TimeDto());
    }
}
