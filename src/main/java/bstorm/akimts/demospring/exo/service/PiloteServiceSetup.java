package bstorm.akimts.demospring.exo.service;

import bstorm.akimts.demospring.exo.model.Pilote;
import bstorm.akimts.demospring.exo.model.Voiture;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
@Profile("exo")
public class PiloteServiceSetup /* implements InitializingBean, DisposableBean */ {

    private final String propNom;
    private final String propPrenom;
    private final PiloteService service;

    public PiloteServiceSetup(@Value("${custom.nom}") String propNom, @Value("${custom.prenom}") String propPrenom, PiloteService service) {
        this.propNom = propNom;
        this.propPrenom = propPrenom;
        this.service = service;
    }

    @PostConstruct
    public void init(){
        service.add(
                new Pilote(
                        propPrenom,
                        propNom,
                        "VrimVroom",
                        new Voiture("VrimVroom", "Bleh", 12)
                )
        );
    }

    @PreDestroy
    public void destruct(){
        System.out.println("avant la destruction de PiloteServiceSetup");
    }

//    Avec InitializingBean et DisposableBean:

//    @Override
//    public void afterPropertiesSet() throws Exception {
//        service.add(
//                new Pilote(
//                        propPrenom,
//                        propNom,
//                        "VrimVroom",
//                        new Voiture("VrimVroom", "Bleh", 12)
//                )
//        );
//    }

//    @Override
//    public void destroy() throws Exception {
//        System.out.println("avant la destruction de PiloteServiceSetup");
//    }
}