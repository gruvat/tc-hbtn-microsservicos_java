package com.example.calculator.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

    private Calculator calc;

    @BeforeEach
    void config() {
        calc = new Calculator();
    }
    
    @Test
    void sumTest() {
        Double number1 = 5.;
        Double number2 = 10.;
        assertEquals(15, calc.sum(number1, number2));
    }

    @Test
    public void numbersNullSumTest() {
        Double number1 = null;
        Double number2 = 10.;
        assertThrows(NullPointerException.class, () -> calc.sum(number1, number2));
    }

    @Test
    void subTest() {
        Double number1 = 5.;
        Double number2 = 10.;
        assertEquals(-5, calc.sub(number1, number2));
    }

    @Test
    void divideTest() {
        Double number1 = 10.;
        Double number2 = 5.;
        assertEquals(2., calc.divide(number1, number2));
    }

    @Test
    public void divisionByZeroTest() {
        Double number1 = 10.;
        Double number2 = 0.;
        assertThrows(ArithmeticException.class, () -> calc.divide(number1, number2));
    }

    @Test
    void factorialTest() {
        Integer fat = 5;
        assertEquals(120, calc.factorial(fat));
    }

    @Test
    void integerToBinaryTest() {
        Integer number = 8;
        Integer result = 1000;
        assertEquals(result, calc.integerToBinary(number));
    }

    @Test
    void integerToHexadecimalTest() {
        Integer number = 10;
        String result = "A";
        assertEquals(result.toLowerCase(), calc.integerToHexadecimal(number).toLowerCase());
    }

    @Test
    void calculeDayBetweenDateTest() {
        LocalDate firstDate = LocalDate.of(2017, 12, 31);
        LocalDate finalDate = LocalDate.of(2022, 01, 30);
        int result = Long.valueOf(firstDate.datesUntil(finalDate).count()).intValue();
        assertEquals(result, calc.calculeDayBetweenDate(firstDate, finalDate));
    }
}
