package fr.lightning.Test;

import fr.lightning.models.Avocat;
import fr.lightning.models.Client;
import fr.lightning.models.Facture;
import fr.lightning.models.Rdv;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class FactureTest {
    @Test
    @Order(1)
    void getAllFacture() {
        List<Facture> factureList = this.CreateFactureListe();
        if (factureList.size() == 1) {
            System.out.println("true : element_count = " + factureList.size());
        } else {
            System.out.println("false : element_count = " + factureList.size() + ", attendu : 1");
        }
    }

    @Test
    @Order(2)
    void DeleteFacture() {
        List<Facture> factureList = this.CreateFactureListe();

        factureList.remove(0);

        if (factureList.size() == 0) {
            System.out.println("true : la suppression c'est bien passée, count = " + factureList.size()  + ", attendu : 0");
        } else {
            System.out.println("false : la suppression c'est mal passée, count = " + factureList.size() + ", attendu : 0");
        }
    }

    @Test
    @Order(3)
    void createFacture() {
        List<Facture> factureList = this.CreateFactureListe();

        Avocat avocatRdv = new Avocat();
        avocatRdv.setId(2);

        Client clientRdv = new Client();
        clientRdv.setId(2);

        Rdv rdvFacture = new Rdv("", "", 1, clientRdv, avocatRdv);
        rdvFacture.setId(2);

        Facture factureToAdd = new Facture(3, 10.5, 0, rdvFacture);
        factureToAdd.setId(2);

        factureList.add(factureToAdd);

        if (factureList.size() == 2) {
            System.out.println("true : l'ajout c'est bien passé, count = " + factureList.size()  + ", attendu : 2");
        } else {
            System.out.println("false : l'ajout c'est mal passé, count = " + factureList.size()  + ", attendu : 2");
        }
    }

    @Test
    @Order(4)
    void checkFactureByAvocatIdClientId() {
        List<Facture> factureList = this.CreateFactureListe();

        int id_rdv = 1;

        for (int i = 0; i < factureList.size(); i++) {
            if (id_rdv == factureList.get(i).getRdv().getId()) {
                System.out.println("true : " + factureList.get(i).toString() + " 'id 1' attendu");
            } else {
                System.out.println("false : " + factureList.get(i).toString() + " 'id 1' attendu");
            }
        }
    }

    private List<Facture> CreateFactureListe() {
        List<Facture> result = new ArrayList<>();

        Avocat avocatRdv = new Avocat();
        avocatRdv.setId(1);

        Client clientRdv = new Client();
        clientRdv.setId(1);

        Rdv rdvFacture = new Rdv("", "", 1, clientRdv, avocatRdv);
        rdvFacture.setId(1);

        Facture facture1 = new Facture(3, 10.5, 0, rdvFacture);
        facture1.setId(1);

        result.add(facture1);

        return result;
    }
}
