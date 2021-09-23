package bstorm.akimts.demospring.demo.loop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentB {

    @Autowired
    private ComponentA dependance;

    public ComponentB() {}
}
