package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.services.DBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("db")
@Tag(name = "Работа с БД")
@RequiredArgsConstructor

public class DBController {

    private final DBService dbService;

    @GetMapping("persons")
    @Operation(summary = "Получить список персон")
    public List<PersonEntity> getPersons(){
        return dbService.getPersons();
    }
}
