package bstorm.akimts.demospring.exo.service;

import bstorm.akimts.demospring.exo.model.Voiture;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("exo")
public class VoitureService {

    private final List<Voiture> voitures = new ArrayList<>();

    public List<Voiture> getAll(){
        return new ArrayList<>(voitures);
    }

    public boolean add(Voiture toAdd){
        if( !contains(toAdd) ){
            voitures.add(toAdd);
            return true;
        }
        return false;
    }

    public boolean contains(Voiture v){
        return voitures.contains(v);
    }

}
