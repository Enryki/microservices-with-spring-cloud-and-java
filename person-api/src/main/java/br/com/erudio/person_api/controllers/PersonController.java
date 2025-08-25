package br.com.erudio.person_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.person_api.models.Person;
import br.com.erudio.person_api.services.PersonServices;


@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonServices service;
    //private PersonService service = new PersonService();

    @GetMapping(value = "/{id}",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person findById(@PathVariable("id") Long id){
        return service.findById(id);
    }

    @GetMapping(value = "/all",
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Person> findAll(){
        return service.findAll();
    }

    @PostMapping(value = "/create", 
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person create(@RequestBody Person person) {
        return service.create(person);
    }

    @PatchMapping(value = "/update", 
                    consumes = MediaType.APPLICATION_JSON_VALUE,
                    produces = MediaType.APPLICATION_JSON_VALUE)
    public Person update(@RequestBody Person person) {
        return service.update(person);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    

}
