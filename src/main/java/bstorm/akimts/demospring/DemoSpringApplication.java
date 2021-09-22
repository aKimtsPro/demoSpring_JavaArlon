package bstorm.akimts.demospring;

import bstorm.akimts.demospring.presentation.Menu;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(DemoSpringApplication.class, args);
		Menu m = ctx.getBean(Menu.class);
		m.start();
	}

}
