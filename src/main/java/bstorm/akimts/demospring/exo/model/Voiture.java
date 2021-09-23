package bstorm.akimts.demospring.exo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Voiture {

    private String marque;
    private String modele;
    private int puissance;
}
