package org.example.controllers;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

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
//    @ValueSource(ints = {2,3,4})
    @CsvSource({"2,3","3,5"})
    @DisplayName("Вычитание")
    void subtract(Integer argument, Integer argument2) {
        assertEquals(argument - argument2,calculatorController.subtract(argument, argument2));
    }

    @ParameterizedTest
    @ValueSource(ints = {4,6,60})
    @DisplayName("Умножение")
    void multiply(Integer argument) {
        assertEquals(argument * 2,calculatorController.multiply( argument,  2));
    }

    @Test
    @DisplayName("Деление")
    void divide() {
        assertEquals(3,calculatorController.divide(6,2));
    }
}