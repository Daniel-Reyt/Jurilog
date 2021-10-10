package fr.lightning.Test;

import fr.lightning.entity.*;
import junit.framework.TestCase;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class FactureTest extends TestCase {
    @Test
    @Order(1)
    public static void testgetAllFacture() {
        List<Facture> factureList = CreateFactureListe();
        assertEquals(1, factureList.size());
    }

    @Test
    @Order(2)
    public static void testDeleteFacture() {
        List<Facture> factureList = CreateFactureListe();

        factureList.remove(0);

        assertEquals(0, factureList.size());
    }

    @Test
    @Order(3)
    public static void testcreateFacture() {
        List<Facture> factureList = CreateFactureListe();

        Avocat avocatRdv = new Avocat();
        avocatRdv.setId(2);

        Client clientRdv = new Client();
        clientRdv.setId(2);

        TypeRdv typeRdv = new TypeRdv("administration", 20.00);

        Rdv rdvFacture = new Rdv("", "", 1, clientRdv, avocatRdv, typeRdv);
        rdvFacture.setId(2);

        Facture factureToAdd = new Facture(3, 10.5, "0", rdvFacture);
        factureToAdd.setId(2);

        factureList.add(factureToAdd);

        assertEquals(2, factureList.size());
    }

    private static List<Facture> CreateFactureListe() {
        List<Facture> result = new ArrayList<>();

        Avocat avocatRdv = new Avocat();
        avocatRdv.setId(1);

        Client clientRdv = new Client();
        clientRdv.setId(1);

        TypeRdv typeRdv = new TypeRdv("administration", 20.00);

        Rdv rdvFacture = new Rdv("", "", 1, clientRdv, avocatRdv, typeRdv);
        rdvFacture.setId(1);

        Facture facture1 = new Facture(3, 10.5, "0", rdvFacture);
        facture1.setId(1);

        result.add(facture1);

        return result;
    }
}
