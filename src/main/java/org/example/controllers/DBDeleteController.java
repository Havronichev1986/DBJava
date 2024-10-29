package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.example.services.DBDeleteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("db")
@Tag(name = "Удаление из базы данных")
@RequiredArgsConstructor
public class DBDeleteController {

    private final DBDeleteService dbService;

    @Schema(example = "1")
    @DeleteMapping("{id}")
    @Operation(summary = "Удалить список персон")
    public ResponseEntity<Void> deletePersons(@PathVariable Long id) {
        dbService.deletePersons(id);
        return ResponseEntity.noContent().build();
    }
}
