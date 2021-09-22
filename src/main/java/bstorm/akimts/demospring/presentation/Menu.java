package bstorm.akimts.demospring.presentation;

import bstorm.akimts.demospring.metier.PersonService;
import bstorm.akimts.demospring.model.Person;
import org.springframework.beans.factory.InitializingBean;

import java.util.Scanner;

public class Menu /* implements InitializingBean */ {

    private final PersonService service;
    private final Scanner sc;

    public Menu(PersonService service, Scanner sc) {
        this.service = service;
        this.sc = sc;
    }

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
        Person.PersonBuilder builder = Person.builder();

        System.out.print("nom : ");
        builder.nom( sc.nextLine() );
        System.out.print("age: ");
        builder.age( Integer.parseInt(sc.nextLine()) );

        service.add( builder.build() );
    }

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        System.out.println("afterPropertiesSet");
//        start();
//    }
}
