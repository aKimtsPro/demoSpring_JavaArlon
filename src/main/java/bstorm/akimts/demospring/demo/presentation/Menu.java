package bstorm.akimts.demospring.demo.presentation;

import bstorm.akimts.demospring.demo.annotation.Impl;
import bstorm.akimts.demospring.demo.metier.PersonService;
import bstorm.akimts.demospring.demo.metier.dto.PersonDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@Profile("demo")
public class Menu{

    @Autowired @Impl
    private /* final */ PersonService service;
    @Autowired
    private /* final */ Scanner sc;

//    public Menu(@Mock PersonService service, Scanner sc) {
//        this.service = service;
//        this.sc = sc;
//    }

    public void start(){

        int choix = 0;
        do{
            displayMenu();
            choix = Integer.parseInt( sc.nextLine() );
            mapChoix(choix);
        }while( choix != 3);

    }

    private void displayMenu() {
        System.out.println("--- MENU PRINCIPAL ---");
        System.out.println("1 - voir tout");
        System.out.println("2 - ajouter");
        System.out.println("3 - quitter");
    }
    private void mapChoix(int choix){
        switch (choix) {
            case 1:
                displayAll();
                break;
            case 2:
                add();
                break;
            case 3:
                quit();
                break;
            default:
                System.out.println("choix invalide");
        }
    }
    private void quit(){
        System.out.println("Au revoir!");
    }
    private void displayAll(){
        service.getAll().forEach(System.out::println);
    }
    private void add(){
        PersonDTO.PersonDTOBuilder builder = PersonDTO.builder();

        System.out.print("nom : ");
        builder.nom( sc.nextLine() );
        System.out.print("age: ");
        builder.age( Integer.parseInt(sc.nextLine()) );

        service.add( builder.build() );
    }

}
