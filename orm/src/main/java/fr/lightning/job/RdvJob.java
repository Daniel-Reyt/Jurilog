package fr.lightning.job;

import fr.lightning.entity.Avocat;
import fr.lightning.entity.Client;

public class RdvJob {
    private int id;
    private String date;
    private String heure_rdv;
    private Client client;
    private Avocat avocat;
    //1 = approved // 0 = en attente // 2 = refusé
    private int status;

    public RdvJob() {
    }

    public RdvJob(String date_rdv, String heure_rdv, int status, Client client, Avocat avocat) {
        this.setDate(date_rdv);
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
