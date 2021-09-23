package bstorm.akimts.demospring.demo.dataaccess.repository;

import bstorm.akimts.demospring.demo.dataaccess.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
