package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {

    public Double sum(Double number1, Double number2) {
        if(number1.equals(null) || number2.equals(null)) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 + number2;
    }

    public Double sub(Double number1, Double number2) {
        if(number1.equals(null) || number2.equals(null)) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return number1 - number2;
    }

    public Double divide (Double number1, Double number2)  {
        if(number1.equals(null) || number2.equals(null)) {
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        } else if (number2.equals(0.)) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        return number1 / number2;
    }

    public Integer factorial(Integer factorial) {
        if(factorial.equals(null)) {
            throw new NullPointerException("Número é obrigatório.");
        }

        Integer res = factorial;

        while(factorial > 1) {
            res = res * (factorial-1);
            factorial -= 1;
        }
        return res;
    }

    public Integer integerToBinary(Integer integer) {
        return Integer.parseInt(Integer.toBinaryString(integer));
    }   

    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer);
    }

    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        // Solution using Stream
        //long diff = date2.datesUntil(date2).count();

        return Long.valueOf(ChronoUnit.DAYS.between(date1, date2)).intValue();
    }
}
