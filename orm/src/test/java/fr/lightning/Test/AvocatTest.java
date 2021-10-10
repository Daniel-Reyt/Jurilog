package fr.lightning.Test;

import fr.lightning.entity.Avocat;
import fr.lightning.entity.Client;
import junit.framework.TestCase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class AvocatTest extends TestCase {

    @Test
    @Order(1)
    public static void testGetAllUser() throws Exception {
        List<Avocat> avocatList = CreateAvocatListe();
        assertEquals(3, avocatList.size());
    }

    @Test
    @Order(2)
    public static void testDeleteUser() {
        List<Avocat> avocatList = CreateAvocatListe();

        avocatList.remove(2);
        assertEquals(2, avocatList.size());
    }

    @Test
    @Order(3)
    public static void testCreateUser() {
        List<Avocat> avocatList = CreateAvocatListe();

        Avocat avocatToAdd = new Avocat("new client","new client", "new client", "new client", "new client", "new client");
        avocatList.add(avocatToAdd);
        assertEquals(4, avocatList.size());
    }

    private static List<Avocat> CreateAvocatListe() {
        List<Avocat> result = new ArrayList<>();

        Avocat avocat1 = new Avocat("test 1", "test 1", "test 1", "test 1", "test 1", "test 1");
        Avocat avocat2 = new Avocat("test 2", "test 2", "test 2", "test 2", "test 2", "test 2");
        Avocat avocat3 = new Avocat("test 3", "test 3", "test 3", "test 3", "test 3", "test 3");

        result.add(avocat1);
        result.add(avocat2);
        result.add(avocat3);

        return result;
    }
}
