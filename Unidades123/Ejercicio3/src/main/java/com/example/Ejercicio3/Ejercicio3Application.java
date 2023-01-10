package com.example.Ejercicio3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Ejercicio3Application {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Ejercicio3Application.class, args);
		CocheRepository repository = context.getBean(CocheRepository.class);

		Coche corolla = new Coche(null,"Toyota","Corolla",2007);
		repository.save(corolla);
		System.out.println(repository.findAll());

	}

}
