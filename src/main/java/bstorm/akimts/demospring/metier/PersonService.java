package bstorm.akimts.demospring.metier;

import bstorm.akimts.demospring.model.Person;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

import java.util.ArrayList;
import java.util.List;

public class PersonService implements InitializingBean, DisposableBean {

    private final List<Person> list= new ArrayList<>();

    public List<Person> getAll(){
        return new ArrayList<>(list);
    }

    public void add(Person toAdd){
        list.add(toAdd);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Remplissage de la liste");
        list.add(new Person("luc", 45));
        list.add(new Person("marie", 25));
        list.add(new Person("louise", 62));
        list.add(new Person("dominique", 33));
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("avant destruction");
    }
}
