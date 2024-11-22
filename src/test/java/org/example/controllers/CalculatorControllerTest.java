package org.example.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    @Test
    @DisplayName("Сложение")
    void add() {
        CalculatorController calculatorController = new CalculatorController();
        Double result = calculatorController.add(2d,3d);
        assertEquals(5,result);
    }

    @Test
    @DisplayName("Вычитание")
    void subtract() {
        CalculatorController calculatorController = new CalculatorController();
        Double result = calculatorController.subtract(5d,2d);
        assertEquals(3,result);
    }

    @Test
    @DisplayName("Умножение")
    void multiply() {
        CalculatorController calculatorController = new CalculatorController();
        Double result = calculatorController.multiply(2d,2d);
        assertEquals(4,result);
    }

    @Test
    @DisplayName("Деление")
    void divide() {
        CalculatorController calculatorController = new CalculatorController();
        Double result = calculatorController.divide(6d,2d);
        assertEquals(3,result);
    }
}