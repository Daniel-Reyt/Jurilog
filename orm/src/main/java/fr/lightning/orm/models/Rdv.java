package fr.lightning.orm.models;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date_rdv;
    private String heure_rdv;
    @OneToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    private Client client;
    @OneToOne(targetEntity = Avocat.class, fetch = FetchType.LAZY)
    private Avocat avocat;
    //1 = approved // 0 = en attente // 2 = refusé
    private int status;

    public Rdv() {
    }

    public Rdv(String date_rdv, String heure_rdv, int status, Client client, Avocat avocat) {
        this.setDate_rdv(date_rdv);
        this.setHeure_rdv(heure_rdv);
        this.setStatus(status);
        this.setClient(client);
        this.setAvocat(avocat);
    }

    //setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate_rdv(String date_rdv) {
        this.date_rdv = date_rdv;
    }

    public void setHeure_rdv(String heure_rdv) {
        this.heure_rdv = heure_rdv;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAvocat(Avocat avocat) {
        this.avocat = avocat;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    //getters
    public String getDate_rdv() {
        return date_rdv;
    }

    public String getHeure_rdv() {
        return heure_rdv;
    }

    public Client getClient() {
        return client;
    }

    public Avocat getAvocat() {
        return avocat;
    }

    public int getStatus() {
        return status;
    }

    //ToString

    @Override
    public String toString() {
        return "Rdv{" +
                "id=" + id +
                ", date_rdv='" + date_rdv + '\'' +
                ", heure_rdv='" + heure_rdv + '\'' +
                ", client=" + client.getId() +
                ", avocat=" + avocat.getId() +
                ", status=" + status +
                '}';
    }
}
