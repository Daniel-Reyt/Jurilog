package fr.lightning.entity;

import fr.lightning.job.RdvJob;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String heure_rdv;
    @OneToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    private Client client;
    @OneToOne(targetEntity = Avocat.class, fetch = FetchType.LAZY)
    private Avocat avocat;
    //1 = approved // 0 = en attente // 2 = refusé
    private int status;

    public Rdv() {
    }

    public Rdv(RdvJob rdvJob) {
        this.setDate(rdvJob.getDate());
        this.setHeure_rdv(rdvJob.getHeure_rdv());
        this.setStatus(rdvJob.getStatus());
        this.setClient(rdvJob.getClient());
        this.setAvocat(rdvJob.getAvocat());
    }

    //setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String date_rdv) {
        this.date = date_rdv;
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
    public String getDate() {
        return date;
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
                ", date_rdv='" + date + '\'' +
                ", heure_rdv='" + heure_rdv + '\'' +
                ", client=" + client.getId() +
                ", avocat=" + avocat.getId() +
                ", status=" + status +
                '}';
    }
}
