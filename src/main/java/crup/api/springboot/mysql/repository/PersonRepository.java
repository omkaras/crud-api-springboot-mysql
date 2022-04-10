package crup.api.springboot.mysql.repository;

import crup.api.springboot.mysql.entity.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, Long> {

    public List<Person> findAll();

    public Optional<Person> findById(int id);

    public Person save(Person person);

    public void delete(Person person);
}
