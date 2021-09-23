package bstorm.akimts.demospring;

import bstorm.akimts.demospring.exo.pres.Menu;
import bstorm.akimts.demospring.exo.model.Voiture;
import bstorm.akimts.demospring.exo.service.VoitureService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoSpringApplication.class, args);
//		Menu m = ctx.getBean("menu1", Menu.class);
//		m.start();

		bstorm.akimts.demospring.demo.presentation.Menu m;
		m = ctx.getBean(bstorm.akimts.demospring.demo.presentation.Menu.class);
		m.start();
	}

}
