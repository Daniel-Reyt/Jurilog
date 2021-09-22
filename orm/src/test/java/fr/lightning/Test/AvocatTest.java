package fr.lightning.Test;

import fr.lightning.models.Avocat;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.ArrayList;
import java.util.List;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class AvocatTest {

    @Test
    @Order(1)
    void getAllAvocat() {
        List<Avocat> avocatList = this.CreateAvocatListe();
        if (avocatList.size() == 3) {
            System.out.println("true : element_count = " + avocatList.size());
        } else {
            System.out.println("false : element_count = " + avocatList.size() + ", attendu : 3");
        }
    }

    @Test
    @Order(2)
    void DeleteAvocat() {
        List<Avocat> avocatList = this.CreateAvocatListe();

        avocatList.remove(2);

        if (avocatList.size() == 2) {
            System.out.println("true : la suppression c'est bien passée, count = " + avocatList.size()  + ", attendu : 2");
        } else {
            System.out.println("false : la suppression c'est mal passée, count = " + avocatList.size() + ", attendu : 2");
        }
    }

    @Test
    @Order(3)
    void createAvocat() {
        List<Avocat> avocatList = this.CreateAvocatListe();

        Avocat avocatToAdd = new Avocat("new client", "new client", "new client", "new client", "new client", "new client");
        avocatList.add(avocatToAdd);

        if (avocatList.size() == 4) {
            System.out.println("true : l'ajout c'est bien passé, count = " + avocatList.size()  + ", attendu : 4");
        } else {
            System.out.println("false : l'ajout c'est mal passé, count = " + avocatList.size()  + ", attendu : 4");
        }
    }

    @Test
    @Order(4)
    void checkAvocatById() {
        List<Avocat> avocatList = this.CreateAvocatListe();

        String Nom_test = "test 1";
        String Prenom_test = "test 1";

        for (int i = 0; i < avocatList.size(); i++) {
            if (Prenom_test == avocatList.get(i).getPrenom()) {
                if (Nom_test == avocatList.get(i).getNom()) {
                    System.out.println("true : " + avocatList.get(i).toString() + " 'test 1' attendu");
                }
            } else {
                System.out.println("false : " + avocatList.get(i).toString() + " 'test 1' attendu");
            }
        }
    }

    private List<Avocat> CreateAvocatListe() {
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
