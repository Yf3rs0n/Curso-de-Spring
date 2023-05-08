package com.example.ejerciciosesiones456.controller;

import com.example.ejerciciosesiones456.entities.Laptop;
import com.example.ejerciciosesiones456.repository.LaptopRepository;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LaptopController {
    private LaptopRepository laptopRepository;

    public LaptopController(LaptopRepository laptopRepository) {
        this.laptopRepository = laptopRepository;
    }

    /**
     *
     * @return
     */
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        //Recuperar y Devolver los libros de la BD
        return laptopRepository.findAll();

    }
    @PostMapping("/api/laptops")
    public Laptop create(@RequestBody Laptop laptop, @RequestHeader HttpHeaders headers){
        System.out.println(headers.get("User-Agent"));
        return laptopRepository.save(laptop);
    }

}
