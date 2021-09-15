package fr.lightning.orm;

import fr.lightning.orm.controller.ClientController;
import fr.lightning.orm.dao.ClientDao;
import fr.lightning.orm.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OrmJuriLogApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrmJuriLogApplication.class, args);
		System.out.println("ORM démarrer");
	}
}
