package fr.lightning.Test;

import fr.lightning.entity.Avocat;
import fr.lightning.entity.Client;
import fr.lightning.entity.Rdv;
import fr.lightning.entity.TypeRdv;
import junit.framework.TestCase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class RdvTest extends TestCase {
    @Test
    @Order(1)
    public static void testgetAllRdv() {
        List<Rdv> rdvList = CreateRdvListe();
        assertEquals(1, rdvList.size());
    }

    @Test
    @Order(2)
    public static void testDeleteRdv() {
        List<Rdv> rdvList = CreateRdvListe();

        rdvList.remove(0);

        assertEquals(0, rdvList.size());
    }

    @Test
    @Order(3)
    public static void testcreateRdv() {
        List<Rdv> rdvList = CreateRdvListe();

        Avocat avocatRdv = new Avocat();
        avocatRdv.setId(2);

        Client clientRdv = new Client();
        clientRdv.setId(1);

        TypeRdv typeRdv = new TypeRdv("administration", 20.00);

        Rdv rdvToAdd = new Rdv("20/02/2022", "20:20", 1, clientRdv, avocatRdv, typeRdv);
        rdvToAdd.setId(2);

        rdvList.add(rdvToAdd);

        assertEquals(2, rdvList.size());
    }

    private static List<Rdv> CreateRdvListe() {
        List<Rdv> result = new ArrayList<>();

        Avocat avocatRdv = new Avocat();
        avocatRdv.setId(1);

        Client clientRdv = new Client();
        clientRdv.setId(1);

        TypeRdv typeRdv = new TypeRdv("administration", 20.00);
        Rdv rdv1 = new Rdv("10/01/2021", "10:10", 1, clientRdv, avocatRdv, typeRdv);
        rdv1.setId(1);

        result.add(rdv1);

        return result;
    }
}
