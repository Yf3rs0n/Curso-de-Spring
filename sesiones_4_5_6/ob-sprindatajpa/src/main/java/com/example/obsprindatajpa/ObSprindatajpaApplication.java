package com.example.obsprindatajpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSprindatajpaApplication {

	public static void main(String[] args) {

		ApplicationContext context  = SpringApplication.run(ObSprindatajpaApplication.class, args);

		CocheRepository repository = context.getBean(CocheRepository.class);//Le pedimos Beans a Spring pasandole la clase

		System.out.println("find");
		System.out.println("Numero de Datos: " + repository.count());

		//Crear y almacenar un coche en la base de datos

		Coche toyota = new Coche(null,"Toyota", "Prado");
		repository.save(toyota);

		System.out.println("Numero de Datos: " + repository.count());

		//Recuperar un coche por ID
		System.out.println(repository.findAll());



	}

}
