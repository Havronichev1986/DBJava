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
    public Double add(@RequestParam Double a, @RequestParam Double b) {
        return a + b;
    }

    @GetMapping("/-")
    @Operation(summary = "вычитание")
    public Double subtract(@RequestParam Double a, @RequestParam Double b) {
        return a - b;
    }

    @GetMapping("/*")
    @Operation(summary = "умножение")
    public Double multiply(@RequestParam Double a, @RequestParam Double b) {
        return a * b;
    }

    @GetMapping("/")
    @Operation(summary = "деление")
    public Double divide(@RequestParam Double a, @RequestParam Double b) {
        return a / b;
    }
}
