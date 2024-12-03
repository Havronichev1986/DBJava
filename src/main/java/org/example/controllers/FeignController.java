package org.example.controllers;

import org.example.services.FeignService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("feign")
public class FeignController {
    private final FeignService feignService;
    public FeignController(FeignService feignService){
        this.feignService = feignService;
    }

    @PostMapping("persons")
    Object getPersons(){
        return feignService.getPersons();
    }
}
