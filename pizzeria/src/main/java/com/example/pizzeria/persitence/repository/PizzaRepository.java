package com.example.pizzeria.persitence.repository;

import com.example.pizzeria.persitence.entity.PizzaEntity;
import org.springframework.data.repository.ListCrudRepository;

public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

}
