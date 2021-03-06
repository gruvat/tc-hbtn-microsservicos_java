package com.example.calculator.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    void messageWelcome() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/welcome")).andReturn();
        assertEquals("Bem vindo à CALCULATOR API REST.", result.getResponse().getContentAsString());
    }

    @Test
    void addNumbers() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/addNumbers")
                                    .param("number1", "5")
                                    .param("number2", "10")
                                )
                                .andExpect(status().isOk())
                                .andReturn();
        assertEquals("15.0", result.getResponse().getContentAsString());
    }

    @Test
    void subNumbers() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/subNumbers")
                                    .param("number1", "5")
                                    .param("number2", "10")
                                )
                                .andExpect(status().isOk())
                                .andReturn();
        assertEquals("-5.0", result.getResponse().getContentAsString());
    }

    @Test
    void divideNumbers() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/divideNumbers")
                                    .param("number1", "10")
                                    .param("number2", "5")
                                )
                                .andExpect(status().isOk())
                                .andReturn();
        assertEquals("2.0", result.getResponse().getContentAsString());
    }

    @Test
    void factorial() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/factorial")
                                    .param("factorial", "5")
                                )
                                .andExpect(status().isOk())
                                .andReturn();
        assertEquals("120", result.getResponse().getContentAsString());
    }

    @Test
    void calculeDayBetweenDate() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/calculeDayBetweenDate")
                                    .param("localDate1", "2017-12-31")
                                    .param("localDate2", "2022-01-30")
                                )
                                .andExpect(status().isOk())
                                .andReturn();

        LocalDate firstDate = LocalDate.of(2017, 12, 31);
        LocalDate finalDate = LocalDate.of(2022, 01, 30);
        String diff = Long.valueOf(firstDate.datesUntil(finalDate).count()).toString();
        assertEquals(diff, result.getResponse().getContentAsString());
    }

    @Test
    void integerToBinary() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/integerToBinary")
                                    .param("number1", "8")
                                )
                                .andExpect(status().isOk())
                                .andReturn();
        assertEquals("1000", result.getResponse().getContentAsString());
    }

    @Test
    void integerToHexadecimal() throws Exception {
        MvcResult result = mvc.perform(get("/calculator/integerToHexadecimal")
                                    .param("number1", "10")
                                )
                                .andExpect(status().isOk())
                                .andReturn();
        assertEquals("a", result.getResponse().getContentAsString().toLowerCase());
    }

}
