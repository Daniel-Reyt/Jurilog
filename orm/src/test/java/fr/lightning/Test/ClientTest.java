package fr.lightning.Test;

import fr.lightning.entity.Client;
import junit.framework.TestCase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class ClientTest extends TestCase {

    @Test
    @Order(1)
    public static void testGetAllUser() throws Exception {
        List<Client> clientList = CreateClientListe();
        assertEquals(3, clientList.size());
    }

    @Test
    @Order(2)
    public static void testDeleteUser() {
        List<Client> clientList = CreateClientListe();

        clientList.remove(2);
        assertEquals(2, clientList.size());
    }

    @Test
    @Order(3)
    public static void testCreateUser() {
        List<Client> clientList = CreateClientListe();

        Client clientToAdd = new Client("new client","new client", "new client", "new client", "new client", "new client");
        clientList.add(clientToAdd);
        assertEquals(4, clientList.size());
    }

    private static List<Client> CreateClientListe() {
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
