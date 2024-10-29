package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DBEditingService {
    private final PersonRepository personRepository;

    public PersonEntity getDataBydId(Long id){
        return personRepository.findById(id).orElse(null);
    }
    public PersonEntity updateData(PersonEntity data){
        return personRepository.save((PersonEntity) data);
    }
}
