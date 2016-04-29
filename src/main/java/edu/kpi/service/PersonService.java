package edu.kpi.service;

import edu.kpi.dao.PersonRepo;
import edu.kpi.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepo personRepo;

    public Person addPerson(Person person) {
        return personRepo.save(person);
    }

    public boolean deletePerson(Person person) {
        Integer toRemove = person.getId();
        return personRepo.exists(toRemove);
    }

    public boolean deletePerson(Integer id) {
        personRepo.delete(id);
        return personRepo.exists(id);
    }

    public boolean personExists(Integer id) {
        return personRepo.exists(id);
    }

    public Person updatePerson(Person person) {
        return personRepo.save(person);
    }

    public List<Person> getAllPeople() {
        return personRepo.findAll();
    }

}
