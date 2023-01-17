package com.example.appREST;

import com.example.appREST.Entities.Laptop;
import com.example.appREST.Repositories.LaptopRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class AppRestApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(AppRestApplication.class, args);
		LaptopRepository repository = context.getBean(LaptopRepository.class);
		Laptop hp = new Laptop(null,"hp","pavillion","i5",8);
		Laptop dell = new Laptop(null,"dell","inspirion","Ryzen5",16);
		repository.save(hp);
		repository.save(dell);
	}

}
