package crup.api.springboot.mysql.controller;

import crup.api.springboot.mysql.entity.Person;
import crup.api.springboot.mysql.entity.PersonDetails;
import crup.api.springboot.mysql.service.AppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/crud/v1")
public class CrudAppController {

    @Autowired
    private AppService service;

    @GetMapping("/")
    public ResponseEntity<String> greet(){
        return new ResponseEntity<>("Hello!", HttpStatus.OK);
    }

    @GetMapping("/persons")
    public PersonDetails getAllPersons(){
        return this.service.getAllPersons();
    }

    @PostMapping("/person")
    public Person savePerson(@RequestBody Person person){
        return this.service.savePerson(person);
    }

    @DeleteMapping("/person/{personId}")
    public ResponseEntity<String> deletePerson(@PathVariable int personId){
        return this.service.deletePerson(personId);
    }

    @PutMapping("person")
    public ResponseEntity<String> updatePerson(@RequestBody Person person){
        return this.service.updatePerson(person);
    }

}
