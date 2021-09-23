package bstorm.akimts.demospring.exo.service;

import bstorm.akimts.demospring.exo.model.Pilote;
import bstorm.akimts.demospring.exo.model.Voiture;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Profile("exo")
public class PiloteService implements InitializingBean {

    private final VoitureService vService;
    private final List<Pilote> pilotes = new ArrayList<>();

    public PiloteService(VoitureService vService) {
        this.vService = vService;
    }

    public List<Pilote> getAll(){
        return new ArrayList<>(pilotes);
    }

    public boolean add(Pilote toAdd){
        if( !pilotes.contains(toAdd) ){
            pilotes.add(toAdd);
            if( !vService.contains(toAdd.getVoiture()) ){
                vService.add( toAdd.getVoiture() );
            }
            return true;
        }
        return false;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        Voiture v = new Voiture("VrimVroom", "BipBoop", 234574);
        add( new Pilote("luc", "dubois", "VrimVroom", v) );
        add( new Pilote("marie", "dubosquet", "VrimVroom", v) );
    }
}
