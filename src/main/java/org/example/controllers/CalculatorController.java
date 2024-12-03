package org.example.controllers;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor

public class CalculatorController {

    @GetMapping("/+")
    @Operation(summary = "сложение")
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {return a + b;}

    @GetMapping("/-")
    @Operation(summary = "вычитание")
    public Integer subtract(@RequestParam Integer a, @RequestParam Integer b) {
        return a - b;
    }

    @GetMapping("/*")
    @Operation(summary = "умножение")
    public Integer multiply(@RequestParam Integer a, @RequestParam Integer b) {
        return a * b;
    }

    @GetMapping("/")
    @Operation(summary = "деление")
    public Integer divide(@RequestParam Integer a, @RequestParam Integer b) {
        return a / b;
    }
}
