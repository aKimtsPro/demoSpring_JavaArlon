package bstorm.akimts.demospring.demo.metier;

import bstorm.akimts.demospring.demo.annotation.Mock;
import bstorm.akimts.demospring.demo.metier.dto.PersonDTO;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Primary
@Mock
@Qualifier("bim")
@Service("personServiceMock")
@Profile({"demo", "mock"})
public class PersonServiceMock implements PersonService, InitializingBean, DisposableBean {

    private final List<PersonDTO> list= new ArrayList<>();

    public List<PersonDTO> getAll(){
        return new ArrayList<>(list);
    }

    public void add(PersonDTO toAdd){
        list.add(toAdd);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Remplissage de la liste impl");
        list.add(new PersonDTO(1,"luc",45));
        list.add(new PersonDTO(2,"marie",25));
        list.add(new PersonDTO(3,"louise",62));
        list.add(new PersonDTO(4,"dominique",33));
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("avant destruction impl");
    }
}
