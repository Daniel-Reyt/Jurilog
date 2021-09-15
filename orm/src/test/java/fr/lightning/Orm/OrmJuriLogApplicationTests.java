package fr.lightning.Orm;

import fr.lightning.orm.controllers.ClientController;
import fr.lightning.orm.models.Client;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

class OrmJuriLogApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	void getAllUser() {
		List<Client> clientList = new ArrayList<>();
		if (clientList.stream().count() == 0) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
	}

}
