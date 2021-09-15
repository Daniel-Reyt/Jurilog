package fr.lightning.orm.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Avocats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int avocatId;
    private String nom;
    private String prenom;
    private String adress;
    private String phone;
    private String username;
    private String type;

    //a ne pas afficher
    private String password;

    public Avocats() {
    }

    public Avocats(String nom, String prenom, String adress, String phone, String username, String password) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdress(adress);
        this.setPhone(phone);
        this.setUsername(username);
        this.setPassword(password);
        this.setType("Avocat");
    }

    @Override
    public String toString() {
        return "ClientApp{" +
                "id=" + avocatId +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", adress='" + adress + '\'' +
                ", phone=" + phone +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    //setters
    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return avocatId;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //getters
    public int getAvocatId() {
        return avocatId;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getAdress() {
        return adress;
    }

    public String getPhone() {
        return phone;
    }

    public String getUsername() {
        return username;
    }

    public String getType() {
        return type;
    }

    public String getPassword() {
        return password;
    }
}
