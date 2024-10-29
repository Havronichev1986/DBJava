package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.services.DBSaveService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("db")
@Tag(name = "Сохранение в базу данных")
@RequiredArgsConstructor
public class DBSaveController {

    private final DBSaveService dbService;

    @PostMapping("persons")
    @Operation(summary = "Сохранить список персон")
    public List<PersonEntity> postPersons(@RequestBody List<PersonEntity> personEntities){
        return dbService.postPersons(personEntities);
    }
}
