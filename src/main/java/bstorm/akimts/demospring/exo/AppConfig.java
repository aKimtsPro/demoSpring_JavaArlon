package bstorm.akimts.demospring.exo;

import bstorm.akimts.demospring.exo.model.Pilote;
import bstorm.akimts.demospring.exo.pres.Menu;
import bstorm.akimts.demospring.exo.service.PiloteService;
import bstorm.akimts.demospring.exo.service.VoitureService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Scanner;

@Configuration
@Profile("exo")
public class AppConfig {

    @Bean
    public Scanner scanner(){
        System.out.println("scanner instanc.");
        return new Scanner(System.in);
    }

    @Bean(name = "menu1")
    public Menu menu(
            PiloteService piloteService,
            VoitureService voitureService,
            Scanner scanner
    ){
        System.out.println("menu instanc.");
        return new Menu(piloteService, voitureService, scanner);
    }
}
