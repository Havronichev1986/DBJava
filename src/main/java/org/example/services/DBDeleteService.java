package org.example.services;

import lombok.RequiredArgsConstructor;
import org.example.repositories.PersonRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor

public class DBDeleteService {
    private final PersonRepository personRepository;

    public void deletePersons(Long id){
        personRepository.deleteById(id);
    }
}