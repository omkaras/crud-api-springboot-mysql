package crup.api.springboot.mysql.service;

import crup.api.springboot.mysql.entity.Person;
import crup.api.springboot.mysql.entity.PersonDetails;
import crup.api.springboot.mysql.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppService {

    @Autowired
    PersonRepository repository;

    public PersonDetails getAllPersons() {

        PersonDetails response = new PersonDetails();
        List<Person> apiResponse = repository.findAll();
        response.setPersons(apiResponse);
        return response;
    }

    public Person savePerson(Person person) {
        return this.repository.save(person);
    }

    public ResponseEntity<String> deletePerson(int personId) {
        Optional<Person> personFromDb = this.repository.findById(personId);

        if(personFromDb.isPresent()){
            this.repository.delete(personFromDb.get());
            return new ResponseEntity<>("Person deleted successfully!", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Cannot find person with id-"+personId, HttpStatus.NOT_FOUND);
        }
    }

    public ResponseEntity<String> updatePerson(Person person) {

        Optional<Person> personFromDB = this.repository.findById(person.getId());
        if(personFromDB.isPresent()){
            if(person.equals(personFromDB)){
                return new ResponseEntity<>("No new data to update", HttpStatus.OK);
            }else{
                this.repository.save(person);
                return new ResponseEntity<>("Person updated successfully!", HttpStatus.OK);
            }
        }else{
            return new ResponseEntity<>("Cannot find person with id-"+person.getId(), HttpStatus.NOT_FOUND);
        }
    }
}
