package bstorm.akimts.demospring;

import bstorm.akimts.demospring.demo.dataaccess.entity.Person;
import bstorm.akimts.demospring.demo.dataaccess.repository.PersonRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class ExploRepo {
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(ExploRepo.class, args);

        PersonRepository rep = ctx.getBean(PersonRepository.class);


        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        // INSERT

        if(rep.existsById(598)){
            System.out.println("un update sera fait");
        }
        else{
            System.out.println("un insert sera fait");
        }

        // Une entité avec l'id donnée NE DOIT PAS exister (sinon -> update)
        Person toAdd = Person.builder()
                .id(598)
                .nom("pol")
                .age(89)
                .build();

        rep.save(toAdd);

        // UPDATE

        // Une entité avec l'id donnée DOIT exister (sinon -> insert)
        Person toUpdate = Person.builder()
                .id(1)
                .nom("pol")
                .age(44)
                .build();

        rep.save(toUpdate);

        // GET ONE

        // ATTENTION VERIFICATION DE L'OPTIONAL
        Optional<Person> optionalPerson = rep.findById(1);
        Person p = optionalPerson.orElseThrow();
        System.out.println(p.getId() +" - " + p.getNom() +" - "+ p.getAge());

        // GET ALL

        List<Person> persons = rep.findAll();
        persons.forEach((pers) -> System.out.println(pers.getId() +" - " + pers.getNom() +" - "+ pers.getAge()));


        // DELETE

        // une entité avec l'id donnée DOIT exister
        rep.deleteById(1);
//        rep.delete(Person.builder()
//                .id(1)
//                .build()
//        );
        System.out.println( rep.existsById(1) ? "echec de suppression" : "succes de suppression" );


    }
}
