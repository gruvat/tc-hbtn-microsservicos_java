package com.song.MegaSenaAPI;

import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/megasena")
public class MegaSenaController {
    
    @GetMapping("/simpleMessageWelcome")
    public String mensagemBoasVindas() {
        return "Welcome to the MegaSena api!!!";
    }


    @GetMapping("/getNumbers")
    public List<Integer> numerosMegaSena() {
        Random rand = new Random();
        int upperBound = 60;
        Set<Integer> numbers = new TreeSet<>();

        while(numbers.size() < 6) {
            numbers.add(rand.nextInt(upperBound));
        }

        return numbers.stream().collect(Collectors.toList());
        //return List.copyOf(numbers);  //immutable list
    }
}
