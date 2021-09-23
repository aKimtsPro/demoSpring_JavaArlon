package bstorm.akimts.demospring.exo.pres;

import bstorm.akimts.demospring.exo.model.Pilote;
import bstorm.akimts.demospring.exo.model.Voiture;
import bstorm.akimts.demospring.exo.service.PiloteService;
import bstorm.akimts.demospring.exo.service.VoitureService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component("menu2")
@Profile("exo")
public class Menu {

    private final PiloteService pService;
    private final VoitureService vService;
    private final Scanner sc;

    public Menu(PiloteService pService, VoitureService vService, Scanner sc) {
        this.pService = pService;
        this.vService = vService;
        this.sc = sc;
    }

    public void start(){

        int choix = 0;
        do{
            displayMenu();
            choix = Integer.parseInt( sc.nextLine() );
            mapChoix(choix);
        }while( choix != 4);

    }

    private void displayMenu() {
        System.out.println("--- MENU PRINCIPAL ---");
        System.out.println("1 - afficher pilotes");
        System.out.println("2 - afficher voitures");
        System.out.println("3 - ajouter pilote");
        System.out.println("4 - quitter");
    }
    private void mapChoix(int choix){
        switch (choix) {
            case 1:
                displayPilotes();
                break;
            case 2:
                displayVoitures();
                break;
            case 3:
                addPilote();
                break;
            case 4:
                quit();
                break;
            default:
                System.out.println("choix invalide");
        }
    }

    private void displayVoitures(){
        vService.getAll()
                .forEach( System.out::println );
    }
    private void displayPilotes(){
        pService.getAll()
                .forEach( System.out::println );
    }
    private void addPilote(){

        Pilote.PiloteBuilder pBuilder = Pilote.builder();

        System.out.print("prenom: ");
        pBuilder.prenom(sc.nextLine());
        System.out.print("nom: ");
        pBuilder.nom(sc.nextLine());
        System.out.print("sponsor: ");
        pBuilder.sponsor(sc.nextLine());

        System.out.println("Voulez-vous associer une voiture existante? (y/n)");
        if( sc.nextLine().equals("y") ){
            // associer une voiture existante

            List<Voiture> copy = vService.getAll();
            for (int i = 0; i < copy.size() ; i++) {
                System.out.println(i + " - " + copy.get(i));
            }

            try{
                System.out.println("Quel voiture associer? (index)");
                int index = Integer.parseInt( sc.nextLine() );
                pBuilder.voiture(copy.get(index));

                pService.add( pBuilder.build() );
            }catch (NumberFormatException ex){
                System.out.println("index mal écrit");
                System.out.println("création du pilote annulée");
            }catch (IndexOutOfBoundsException ex){
                System.out.println("index hors list");
                System.out.println("création du pilote annulée");
            }

        }
        else {
            // créer une voiture pour l'associer
            Voiture.VoitureBuilder vBuilder = Voiture.builder();

            System.out.println("Veuillez renseigner les informations sur la voiture.");
            System.out.print("marque: ");
            vBuilder.marque( sc.nextLine() );
            System.out.print("modele: ");
            vBuilder.modele( sc.nextLine() );
            System.out.print("puissance: ");

            try{
                vBuilder.puissance(Integer.parseInt(sc.nextLine()));

                pBuilder.voiture( vBuilder.build() );
                pService.add( pBuilder.build() );

            }catch (NumberFormatException ex){
                System.out.println("puissance invalide");
                System.out.println("creation du pilote annulée");
            }

        }

    }
    private void quit(){
        System.out.println("Au revoir!");
    }
}
