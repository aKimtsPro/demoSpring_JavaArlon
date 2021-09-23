package bstorm.akimts.demospring.demo;

import bstorm.akimts.demospring.demo.annotation.Impl;
import bstorm.akimts.demospring.demo.annotation.Mock;
import bstorm.akimts.demospring.demo.metier.PersonService;
import bstorm.akimts.demospring.demo.metier.PersonServiceImpl;
import bstorm.akimts.demospring.demo.presentation.Menu;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@Configuration
@Profile({"demo","mock","impl"})
public class AppConfig {

    @Bean
    public Scanner scanner(){
        System.out.println("instanciation de scanner");
        return new Scanner(System.in);
    }

//    @Bean
//    public Menu menu(Scanner scanner, @Qualifier("boom") PersonService service){
//        System.out.println("instanciation de menu");
//        return new Menu(service, scanner);
//    }

}
