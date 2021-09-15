package fr.lightning.orm.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rdvId;
    private String date_rdv;
    private String heure_rdv;
    @OneToOne(targetEntity = Clients.class, fetch = FetchType.LAZY)
    private Clients client;
    @OneToOne(targetEntity = Avocats.class, fetch = FetchType.LAZY)
    private Avocats avocat;
    //1 = approved // 0 = en attente // 2 = refusé
    private int status;

    public Rdv() {
    }

    public Rdv(int id, String date_rdv, String heure_rdv, int status, Clients client, Avocats avocat) {
        this.setDate_rdv(date_rdv);
        this.setHeure_rdv(heure_rdv);
        this.setStatus(status);
        this.setClient(client);
        this.setAvocat(avocat);
    }

    //setters
    public int getRdvId() {
        return rdvId;
    }

    public void setRdvId(int id) {
        this.rdvId = id;
    }

    public void setDate_rdv(String date_rdv) {
        this.date_rdv = date_rdv;
    }

    public void setHeure_rdv(String heure_rdv) {
        this.heure_rdv = heure_rdv;
    }

    public void setClient(Clients client) {
        this.client = client;
    }

    public void setAvocat(Avocats avocat) {
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

    public Clients getClient() {
        return client;
    }

    public Avocats getAvocat() {
        return avocat;
    }

    public int getStatus() {
        return status;
    }
}
