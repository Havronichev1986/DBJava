package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.entities.PersonEntity;
import org.example.services.DBEditingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("db")
@Tag(name = "Редактирование БД")
@RequiredArgsConstructor

public class DBEditingController
{
    private final DBEditingService dbService;

    @PutMapping("{id}")
    @Operation(summary = "Редактирование дпнных")

    public PersonEntity updateData(@PathVariable Long id, @RequestBody PersonEntity newData)
    {
        PersonEntity existingData = dbService.getDataBydId(id);
        if (existingData == null)
        {
            throw new RuntimeException("Данные с идентификатором " + id + " не найдены!");
        }
            existingData.setName(newData.getName());
            existingData.setAge(newData.getAge());
            return dbService.updateData(existingData);
    }
}

