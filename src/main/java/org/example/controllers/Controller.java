package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.models.Person;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Методы")
@RequestMapping("test")
public class Controller {
    @GetMapping("get")
    @Operation(summary = "Метод выводит на экран")
    public String test1(@RequestParam("str") String str)
    {
        return "Hello, world, " + str;
    }

    @PostMapping("post")
    @Operation(summary = "Метод добовления")
    public Person test2(@RequestBody Person str)
    {
        return str;
    }
    @PutMapping("put")
    @Operation(summary = "Метод изменения")
    public String test3(@RequestParam String str)
    {
        return str;
    }
    @DeleteMapping("del")
    @Operation(summary = "Метод удаления")
    public void test4(@RequestParam String str)
    {
        System.out.println(str);
    }
}
