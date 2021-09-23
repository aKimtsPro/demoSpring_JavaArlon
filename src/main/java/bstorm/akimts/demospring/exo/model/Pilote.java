package bstorm.akimts.demospring.exo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NonNull;

@Data
@Builder
@AllArgsConstructor
public class Pilote {

    private String prenom;
    private String nom;
    private String sponsor;
    private Voiture voiture;

}
