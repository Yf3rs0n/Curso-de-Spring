package com.example.ejerciciosesiones456;

import com.example.ejerciciosesiones456.entities.Laptop;
import com.example.ejerciciosesiones456.repository.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EjercicioSesiones456Application {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EjercicioSesiones456Application.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);

		Laptop laptop1 = new Laptop(null,"HP","8 GB","512 GB","2048x1536 Flexible",290.999);
		Laptop laptop2 = new Laptop(null,"Intel","16 GB","512 GB","1920x1200",220.999);
		repository.save(laptop1);
		repository.save(laptop2);

	}

}
