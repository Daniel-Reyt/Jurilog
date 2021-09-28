package fr.lightning.objects;

import fr.lightning.entity.Facture;
import fr.lightning.entity.Rdv;

public class FrontRdvObject {
    private int id;
    private String date;
    private String heure_rdv;
    private String client_nom;
    private String client_prenom;
    private String avocat_nom;
    private String avocat_prenom;
    private String status;
    private String status_facture;

    public FrontRdvObject() {
    }

    public FrontRdvObject(Rdv rdv) {
        this.setId(rdv.getId());

        this.setDate(rdv.getDate());
        this.setHeure_rdv(rdv.getHeure_rdv());

        this.setClient_nom(rdv.getClient().getNom());
        this.setClient_prenom(rdv.getClient().getPrenom());

        this.setAvocat_nom(rdv.getAvocat().getNom());
        this.setAvocat_prenom(rdv.getAvocat().getPrenom());

        switch (rdv.getStatus()) {
            case 0:
                this.setStatus("en attente");
                break;
            case 1:
                this.setStatus("approuvé");
                break;
            case 2:
                this.setStatus("refusé");
                break;
        }
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setHeure_rdv(String heure_rdv) {
        this.heure_rdv = heure_rdv;
    }

    public void setClient_nom(String client_nom) {
        this.client_nom = client_nom;
    }

    public void setClient_prenom(String client_prenom) {
        this.client_prenom = client_prenom;
    }

    public void setAvocat_nom(String avocat_nom) {
        this.avocat_nom = avocat_nom;
    }

    public void setAvocat_prenom(String avocat_prenom) {
        this.avocat_prenom = avocat_prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatus_facture(String status_facture) {
        this.status_facture = status_facture;
    }

    public String getStatus_facture() {
        return status_facture;
    }

    public String getDate() {
        return date;
    }

    public String getHeure_rdv() {
        return heure_rdv;
    }

    public String getClient_nom() {
        return client_nom;
    }

    public String getClient_prenom() {
        return client_prenom;
    }

    public String getAvocat_nom() {
        return avocat_nom;
    }

    public String getAvocat_prenom() {
        return avocat_prenom;
    }

    @Override
    public String toString() {
        return "FrontRdvObject{" +
                "date='" + date + '\'' +
                ", heure_rdv='" + heure_rdv + '\'' +
                ", client_nom='" + client_nom + '\'' +
                ", client_prenom='" + client_prenom + '\'' +
                ", avocat_nom='" + avocat_nom + '\'' +
                ", avocat_prenom='" + avocat_prenom + '\'' +
                '}';
    }

}
