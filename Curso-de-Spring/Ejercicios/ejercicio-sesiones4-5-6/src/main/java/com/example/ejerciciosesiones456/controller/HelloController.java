package com.example.ejerciciosesiones456.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    /**
     *http://localhost:8081/api/saludo
     * @return
     */
    @GetMapping("/api/saludo")
    public String saludo (){
        return "Hola Curso de Spring";
    }
}