package fr.lightning.Test;

import fr.lightning.entity.Client;
import fr.lightning.job.ClientJob;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class ClientTest {

    @Test
    @Order(1)
    void getAllUser() {
        List<Client> clientList = this.CreateClientListe();
        if (clientList.size() == 3) {
            System.out.println("true : element_count = " + clientList.size());
        } else {
            System.out.println("false : element_count = " + clientList.size() + ", attendu : 3");
        }
    }

    @Test
    @Order(2)
    void DeleteUser() {
        List<Client> clientList = this.CreateClientListe();

        clientList.remove(2);

        if (clientList.size() == 2) {
            System.out.println("true : la suppression c'est bien passée, count = " + clientList.size()  + ", attendu : 2");
        } else {
            System.out.println("false : la suppression c'est mal passée, count = " + clientList.size()  + ", attendu : 2");
        }
    }

    @Test
    @Order(3)
    void createUser() {
        List<Client> clientList = this.CreateClientListe();

        Client clientToAdd = new Client(new ClientJob("new client","new client", "new client", "new client", "new client", "new client"));
        clientList.add(clientToAdd);

        if (clientList.size() == 4) {
            System.out.println("true : l'ajout c'est bien passé, count = " + clientList.size()  + ", attendu : 4");
        } else {
            System.out.println("false : l'ajout c'est mal passé, count = " + clientList.size()  + ", attendu : 4");
        }
    }

    @Test
    @Order(4)
    void checkUserById() {
        List<Client> clientList = this.CreateClientListe();

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

    private List<Client> CreateClientListe() {
        Client client1 = new Client(new ClientJob("test 1", "test 1", "test 1", "test 1", "test 1", "test 1"));
        Client client2 = new Client(new ClientJob("test 2", "test 2", "test 2", "test 2", "test 2", "test 2"));
        Client client3 = new Client(new ClientJob("test 3", "test 3", "test 3", "test 3", "test 3", "test 3"));

        List<Client> result = new ArrayList<>();
        result.add(client1);
        result.add(client2);
        result.add(client3);
        return result;
    }
}
