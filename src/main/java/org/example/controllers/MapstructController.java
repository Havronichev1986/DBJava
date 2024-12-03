package org.example.controllers;

import lombok.RequiredArgsConstructor;
import org.example.dtos.TemplateDto;
import org.example.services.DBService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MapstructController {
    private final DBService dbService;

    @GetMapping
    public TemplateDto getPerson(){
        return dbService.getPerson();
    }
}
