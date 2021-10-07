package fr.lightning.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String heure;
    @OneToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    private Client client;
    @OneToOne(targetEntity = Avocat.class, fetch = FetchType.LAZY)
    private Avocat avocat;
    //1 = approved // 0 = en attente // 2 = refusé
    private int status;

    public Rdv() {
    }

    public Rdv(String dateRdv, String heureRdv, int status, Client client, Avocat avocat) {
        this.setDate(dateRdv);
        this.setHeure(heureRdv);
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

    public void setDate(String dateRdv) {
        this.date = dateRdv;
    }

    public void setHeure(String heureRdv) {
        this.heure = heureRdv;
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
    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
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
                ", date_rdv='" + date + '\'' +
                ", heure_rdv='" + heure + '\'' +
                ", client=" + client.getId() +
                ", avocat=" + avocat.getId() +
                ", status=" + status +
                '}';
    }
}
