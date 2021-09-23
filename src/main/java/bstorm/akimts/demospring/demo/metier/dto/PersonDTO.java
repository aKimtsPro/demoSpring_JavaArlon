package bstorm.akimts.demospring.demo.metier.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class PersonDTO {

    private int id;
    private String nom;
    private int age;
}
