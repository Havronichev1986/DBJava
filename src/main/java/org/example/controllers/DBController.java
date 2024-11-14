package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.services.DBService;
import org.springframework.http.ResponseEntity;
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
    public List<PersonEntity> getPersons(){
        return dbService.getPersons();
    }


    @PutMapping("persons")
    @Operation(summary = "Редактирование дпнных")
    public PersonEntity updateData(@RequestBody PersonEntity newData) {
        PersonEntity existingData = dbService.getDataBydId(newData.getId());
        if (existingData == null) {
            throw new RuntimeException("Данные с идентификатором " + newData.getId() + " не найдены!");
        }
        existingData.setName(newData.getName());
        existingData.setAge(newData.getAge());
        return dbService.updateData(existingData);
    }

    @PostMapping("persons")
    @Operation(summary = "Сохранить список персон")
    public List<PersonEntity> postPersons(@RequestBody List<PersonEntity> personEntities){
        return dbService.postPersons(personEntities);
    }

//    @Schema(example = "1")
    @DeleteMapping("persons")
    @Operation(summary = "Удалить список персон")
    public ResponseEntity<Void> deletePersons(@RequestBody Long id) {
        dbService.deletePersons(id);
        return ResponseEntity.noContent().build();
    }
}
