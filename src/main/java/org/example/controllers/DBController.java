package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.services.DBService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("db")
@Tag(name = "Работа с БД")
@CrossOrigin
@RequiredArgsConstructor

public class DBController {

    private final DBService dbService;

    @GetMapping("persons")
    @Operation(summary = "Получить список персон")
    public List<PersonEntity> getPersons(@RequestParam(required = false)List<Long>ids)
    {
        return dbService.getPersons(ids);
    }


    @PutMapping("persons")
    @Operation(summary = "Редактирование дпнных")
    public List<PersonEntity>changePersons(@RequestBody List<PersonEntity> personEntities){
        return dbService.createPersons(personEntities);
    }

    @PostMapping("persons")
    @Operation(summary = "Добавить список персон")
    public List<PersonEntity> createPersons(@RequestBody List<PersonEntity> personEntities){
        return dbService.createPersons(personEntities);
    }


    @DeleteMapping("persons")
    @Operation(summary = "Удалить список персон")
    public List<PersonEntity> deletePersons(@RequestBody List<Long> ids) {
        return dbService.deletePersons(ids);
    }
}
