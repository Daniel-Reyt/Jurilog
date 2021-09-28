package fr.lightning.Test;

import fr.lightning.entity.Avocat;
import fr.lightning.entity.Client;
import fr.lightning.entity.Rdv;
import fr.lightning.job.RdvJob;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class RdvTest {
    @Test
    @Order(1)
    void getAllRdv() {
        List<Rdv> rdvList = this.CreateRdvListe();
        if (rdvList.size() == 1) {
            System.out.println("true : element_count = " + rdvList.size());
        } else {
            System.out.println("false : element_count = " + rdvList.size() + ", attendu : 1");
        }
    }

    @Test
    @Order(2)
    void DeleteRdv() {
        List<Rdv> rdvList = this.CreateRdvListe();

        rdvList.remove(0);

        if (rdvList.size() == 0) {
            System.out.println("true : la suppression c'est bien passée, count = " + rdvList.size()  + ", attendu : 0");
        } else {
            System.out.println("false : la suppression c'est mal passée, count = " + rdvList.size() + ", attendu : 0");
        }
    }

    @Test
    @Order(3)
    void createRdv() {
        List<Rdv> rdvList = this.CreateRdvListe();

        Avocat avocatRdv = new Avocat();
        avocatRdv.setId(2);

        Client clientRdv = new Client();
        clientRdv.setId(1);

        Rdv rdvToAdd = new Rdv(new RdvJob("20/02/2022", "20:20", 1, clientRdv, avocatRdv));
        rdvToAdd.setId(2);

        rdvList.add(rdvToAdd);

        if (rdvList.size() == 2) {
            System.out.println("true : l'ajout c'est bien passé, count = " + rdvList.size()  + ", attendu : 2");
        } else {
            System.out.println("false : l'ajout c'est mal passé, count = " + rdvList.size()  + ", attendu : 2");
        }
    }

    @Test
    @Order(4)
    void checkRdvByAvocatIdClientId() {
        List<Rdv> rdvList = this.CreateRdvListe();

        int id_avocat = 1;
        int id_client = 1;

        for (int i = 0; i < rdvList.size(); i++) {
            if (id_avocat == rdvList.get(i).getAvocat().getId()) {
                if (id_client == rdvList.get(i).getClient().getId()) {
                    System.out.println("true : " + rdvList.get(i).toString() + " 'id 1' attendu");
                }
            } else {
                System.out.println("false : " + rdvList.get(i).toString() + " 'id 1' attendu");
            }
        }
    }

    private List<Rdv> CreateRdvListe() {
        List<Rdv> result = new ArrayList<>();

        Avocat avocatRdv = new Avocat();
        avocatRdv.setId(1);

        Client clientRdv = new Client();
        clientRdv.setId(1);

        Rdv rdv1 = new Rdv(new RdvJob("10/01/2021", "10:10", 1, clientRdv, avocatRdv));
        rdv1.setId(1);

        result.add(rdv1);

        return result;
    }
}
