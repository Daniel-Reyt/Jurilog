package fr.lightning.orm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class OrmJuriLogApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(OrmJuriLogApplication.class, args);
		System.out.println("ORM démarrer");
	}
}
