package crup.api.springboot.mysql.entity;

import java.util.List;

public class PersonDetails {

    private List<Person> persons;

    public List<Person> getPersons() {
        return persons;
    }

    public void setPersons(List<Person> persons) {
        this.persons = persons;
    }
}
