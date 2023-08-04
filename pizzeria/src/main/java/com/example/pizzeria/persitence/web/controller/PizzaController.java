package com.example.pizzeria.persitence.web.controller;

import com.example.pizzeria.persitence.entity.PizzaEntity;
import com.example.pizzeria.persitence.service.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pizzas")
public class PizzaController {
    /**
     * Injectamos la clase PizzaService
     */
    private final PizzaService pizzaService;
    @Autowired
    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    /**
     * Metodo GET para obtener todas las pizzas
     */
    @GetMapping
    public ResponseEntity<List<PizzaEntity>> getAll(){
        return ResponseEntity.ok(pizzaService.getAll());
    }

    /**
     * Metodo GET para obtener una pizza
     * @param idPizza
     * @return
     */
    @GetMapping("/{idPizza}")
    public ResponseEntity<PizzaEntity> get(@PathVariable int idPizza){
        return ResponseEntity.ok(this.pizzaService.get(idPizza));
    }

    /**
     * Metodo POST para guardar una pizza
     * @param pizza
     * @return
     */
    @PostMapping
    public ResponseEntity<PizzaEntity> save(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() == null || !this.pizzaService.exists(pizza.getIdPizza())){
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizza){
        if(pizza.getIdPizza() != null && !this.pizzaService.exists(pizza.getIdPizza())){
            /**
             * Utlizamos el metodo save porque los spring repository detectará automaticamente
             * un insert de una pizza nueva o si vamos a actualizar algún elemnento existente
             */
            return ResponseEntity.ok(this.pizzaService.save(pizza));
        }
        return ResponseEntity.badRequest().build();
    }

}
