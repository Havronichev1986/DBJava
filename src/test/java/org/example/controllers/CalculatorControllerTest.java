package org.example.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorControllerTest {

    private static Stream<Arguments> numbersForAddition(){
        return Stream.of(
                Arguments.arguments(2,4,6),
                Arguments.arguments(1,4,5)
        );
    }
    CalculatorController calculatorController = new CalculatorController();

    @ParameterizedTest
    @MethodSource("numbersForAddition")
    @DisplayName("Сложение")
    void add(Integer first, Integer second, Integer expectedSum) {
       Integer  actualSum = first + second;
        assertEquals(expectedSum, actualSum);
    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4})
    @DisplayName("Вычитание")
    void subtract(Integer argument) {
        Integer result = calculatorController.subtract(argument, 2);
        assertEquals(argument - 2,result);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,6,60})
    @DisplayName("Умножение")
    void multiply(Integer argument) {
        Integer result = calculatorController.multiply( argument,  2);
        assertEquals(argument * 2,result);
    }
//
    @Test
    @DisplayName("Деление")
    void divide() {
        Integer result = calculatorController.divide(6,2);
        assertEquals(3,result);
    }
}