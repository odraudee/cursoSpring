package com.example.appREST.Controllers;

import com.example.appREST.Entities.Laptop;
import com.example.appREST.Repositories.LaptopRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

@RestController
public class LaptopController {
    private LaptopRepository repository;
    private final Logger log = LoggerFactory.getLogger(LaptopController.class);

    public LaptopController(LaptopRepository repository) {
        this.repository = repository;
    }
    @GetMapping("/api/hello")
    public String hola(){
        return "Hello, this message came from the controller";
    }

    //findAll
    @GetMapping("/api/laptops")
    public List<Laptop> findAll(){
        return repository.findAll();
    }

    //findById
    @GetMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> getByid(@PathVariable Long id){
        /*findById devuelve un objeto opcional porque puede estar vacio al no existir*/
        Optional<Laptop> laptopOpt = repository.findById(id);
        if (laptopOpt.isPresent())
            //devolver un status 200 con el el elemento buscado
            return ResponseEntity.ok(laptopOpt.get());
        else
            //devolver un 404 si no existe
            return ResponseEntity.notFound().build();
    }

    //create
    @PostMapping("/api/laptops")
    public Laptop save(@RequestBody Laptop laptop){
        return repository.save(laptop);
    }

    //update
    @PutMapping("/api/laptops")
    public ResponseEntity<Laptop> update(@RequestBody Laptop laptop){
        //verificar si el objeto existe usando el id
        if(laptop.getId() == null ){
            //si no tiene id damos un status 400 que nos dice que quiza esta mal el metodo http
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build();
        }
        if(!repository.existsById(laptop.getId())){
            //si el id no existe devolvemos un 404
            log.warn("Trying to update a non existent book");
            return ResponseEntity.notFound().build();
        }
        //cuando si sxiste el id devolvemos el objeto con un status 200
        Laptop result = repository.save(laptop);
        return ResponseEntity.ok(result);
    }

    //delete
    @DeleteMapping("/api/laptops/{id}")
    public ResponseEntity<Laptop> deleteByid(@PathVariable Long id){
        Optional<Laptop> laptopOpt = repository.findById(id);
        if (laptopOpt.isPresent()){
            //si el objeto existe devolvemos un 204, que dice que el objeto no tiene contenido o ya no exoste
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        }
        else{
            //si el elemento no existe devolvemos un 404
            return ResponseEntity.notFound().build();
        }
    }

    //deleteAll
    @DeleteMapping("/api/laptops")
    public ResponseEntity<Laptop> deleteAll(){
        repository.deleteAll();
        return ResponseEntity.noContent().build();
    }
}
