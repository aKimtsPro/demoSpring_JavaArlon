package bstorm.akimts.demospring;

import bstorm.akimts.demospring.metier.PersonService;
import bstorm.akimts.demospring.presentation.Menu;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class AppConfig {

    @Bean
    public PersonService personService(){
        System.out.println("instanciation de personService");
        return new PersonService();
    }

    @Bean
    public Scanner scanner(){
        System.out.println("instanciation de scanner");
        return new Scanner(System.in);
    }

    @Bean
    public Menu menu(Scanner scanner, PersonService service){
        System.out.println("instanciation de menu");
        return new Menu(service, scanner);
    }

}
