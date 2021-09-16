package fr.lightning.Orm;
import fr.lightning.orm.models.Client;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class OrmJuriLogApplicationTests {

	@Test
	void contextLoads() {

	}

	@Test
	@Order(1)
	void getAllUser() {
		List<Client> clientList = this.CreateListe();
		if (clientList.size() == 3) {
			System.out.println("true : element_count = " + clientList.size());
		} else {
			System.out.println("false : element_count = " + clientList.size() + ", attendu : 3");
		}
	}

	@Test
	@Order(2)
	void DeleteUser() {
		List<Client> clientList = this.CreateListe();

		clientList.remove(2);

		if (clientList.size() == 2) {
			System.out.println("true : la suppression c'est bien passée, count = " + clientList.stream().count()  + ", attendu : 2");
		} else {
			System.out.println("false : la suppression c'est mal passée, count = " + clientList.stream().count()  + ", attendu : 2");
		}
	}

	@Test
	@Order(3)
	void createUser() {
		List<Client> clientList = this.CreateListe();

		Client clientToAdd = new Client("new client", "new client", "new client", "new client", "new client", "new client");
		clientList.add(clientToAdd);

		if (clientList.size() == 4) {
			System.out.println("true : l'ajout c'est bien passé, count = " + clientList.stream().count()  + ", attendu : 4");
		} else {
			System.out.println("false : l'ajout c'est mal passé, count = " + clientList.stream().count()  + ", attendu : 4");
		}
	}

	@Test
	@Order(4)
	void checkUserById() {
		List<Client> clientList = this.CreateListe();

		String Nom_test = "test 1";
		String Prenom_test = "test 1";

		for (int i = 0; i < clientList.size(); i++) {
			if (Prenom_test == clientList.get(i).getPrenom()) {
				if (Nom_test == clientList.get(i).getNom()) {
					System.out.println("true : " + clientList.get(i).toString() + " 'test 1' attendu");
				}
			} else {
				System.out.println("false : " + clientList.get(i).toString() + " 'test 1' attendu");
			}
		}
	}

	private List<Client> CreateListe() {
		Client client1 = new Client("test 1", "test 1", "test 1", "test 1", "test 1", "test 1");
		Client client2 = new Client("test 2", "test 2", "test 2", "test 2", "test 2", "test 2");
		Client client3 = new Client("test 3", "test 3", "test 3", "test 3", "test 3", "test 3");

		List<Client> result = new ArrayList<>();
		result.add(client1);
		result.add(client2);
		result.add(client3);
		return result;
	}

}
