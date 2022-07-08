package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


/**
 * MessageResource
 */
@RestController
@RequestMapping("/messages")
public class MessageResource {

    @GetMapping("/simpleMessageWelcome")
    public String simpleMessageWelcome() {
        String message = "BEM VINDO A AULA DE MICROSSERVIÇO USANDO SPRING BOOT !!!";
        return message;
    }

    // http://localhost:8080/messages/login/marcos/123456
    // @GetMapping("/login/{user}/{password}")
    // public String login(@PathVariable String user, @PathVariable String password) {
    //     if((user.isBlank() || user.isEmpty()) || (password.isBlank() || password.isEmpty())) {
    //         return "USUÁRIO E SENHA NÃO INFORMADOS";
    //     } else if(user.length() > 15 || password.length() > 15) {
    //         return "USUÁRIO E SENHA INVÁLIDOS";
    //     }
    //     return "LOGIN EFETUADO COM SUCESSO !!!";
    // }

    // http://localhost:8080/messages/login?user=marcos&password=123456
    @GetMapping("/login")
    public String login(@RequestParam String user, @RequestParam String password) {
        if((user.isBlank() || user.isEmpty()) || (password.isBlank() || password.isEmpty())) {
            return "USUÁRIO E SENHA NÃO INFORMADOS";
        } else if(user.length() > 15 || password.length() > 15) {
            return "USUÁRIO E SENHA INVÁLIDOS";
        }
        return "LOGIN EFETUADO COM SUCESSO !!!";
    }
    
}