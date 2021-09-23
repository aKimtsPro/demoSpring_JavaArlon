package bstorm.akimts.demospring.demo.metier;

import bstorm.akimts.demospring.demo.metier.dto.PersonDTO;

import java.util.List;

public interface PersonService {
    List<PersonDTO> getAll();
    void add(PersonDTO toAdd);
}
