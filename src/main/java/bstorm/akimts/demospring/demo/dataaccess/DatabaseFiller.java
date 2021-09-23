package bstorm.akimts.demospring.demo.dataaccess;

import bstorm.akimts.demospring.demo.dataaccess.entity.Person;
import bstorm.akimts.demospring.demo.dataaccess.repository.PersonRepository;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("demo")
public class DatabaseFiller implements InitializingBean {

    private final PersonRepository repository;

    public DatabaseFiller(PersonRepository repository) {
        this.repository = repository;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        repository.saveAll(List.of(
                Person.builder()
                        .nom("luc")
                        .age(20)
                        .build(),
                Person.builder()
                        .nom("marie")
                        .age(30)
                        .build(),
                Person.builder()
                        .nom("dominique")
                        .age(40)
                        .build()
        ));
    }
}
