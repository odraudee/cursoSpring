package com.example.appREST.Controllers;

import com.example.appREST.Entities.Laptop;
import com.example.appREST.Repositories.LaptopRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private LaptopRepository repository;

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/api/hello")
    public String hola(){
        return "Hello, this message came from the controller";
    }

    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return repository.findAll();
    }

    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> getByid(@PathVariable Long id){
        Optional<Laptop> laptopOpt = repository.findById(id);
        if (laptopOpt.isPresent())
            return ResponseEntity.ok(laptopOpt.get());
        else
            return ResponseEntity.notFound().build();
    }

    @PostMapping("/api/laptops")
    public Laptop save(@RequestBody Laptop laptop){
        return repository.save(laptop);
    }
}
