package fr.lightning.objects;

import fr.lightning.entity.Rdv;

public class FrontRdvObject {
    private int id;
    private String date;
    private String heureRdv;
    private String clientNom;
    private String clientPrenom;
    private String avocatNom;
    private String avocatPrenom;
    private String status;
    private String statusFacture;
    private String rdvTypeName;
    private double rdvTypePercent;

    public FrontRdvObject() {
    }

    public FrontRdvObject(Rdv rdv) {
        this.setId(rdv.getId());

        this.setDate(rdv.getDate());
        this.setHeureRdv(rdv.getHeure());

        this.setClientNom(rdv.getClient().getNom());
        this.setClientPrenom(rdv.getClient().getPrenom());

        this.setAvocatNom(rdv.getAvocat().getNom());
        this.setAvocatPrenom(rdv.getAvocat().getPrenom());

        this.setRdvTypeName(rdv.getType().getTypeRdvName());
        this.setRdvTypePercent(rdv.getType().getPercentAugmentation());

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
            default:
                break;
        }
    }

    public String getRdvTypeName() {
        return rdvTypeName;
    }

    public void setRdvTypeName(String rdvTypeName) {
        this.rdvTypeName = rdvTypeName;
    }

    public double getRdvTypePercent() {
        return rdvTypePercent;
    }

    public void setRdvTypePercent(double rdvTypePercent) {
        this.rdvTypePercent = rdvTypePercent;
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

    public void setHeureRdv(String heureRdv) {
        this.heureRdv = heureRdv;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    public void setClientPrenom(String clientPrenom) {
        this.clientPrenom = clientPrenom;
    }

    public void setAvocatNom(String avocatNom) {
        this.avocatNom = avocatNom;
    }

    public void setAvocatPrenom(String avocatPrenom) {
        this.avocatPrenom = avocatPrenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStatusFacture(String statusFacture) {
        this.statusFacture = statusFacture;
    }

    public String getStatusFacture() {
        return statusFacture;
    }

    public String getDate() {
        return date;
    }

    public String getHeureRdv() {
        return heureRdv;
    }

    public String getClientNom() {
        return clientNom;
    }

    public String getClientPrenom() {
        return clientPrenom;
    }

    public String getAvocatNom() {
        return avocatNom;
    }

    public String getAvocatPrenom() {
        return avocatPrenom;
    }

    @Override
    public String toString() {
        return "FrontRdvObject{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", heureRdv='" + heureRdv + '\'' +
                ", clientNom='" + clientNom + '\'' +
                ", clientPrenom='" + clientPrenom + '\'' +
                ", avocatNom='" + avocatNom + '\'' +
                ", avocatPrenom='" + avocatPrenom + '\'' +
                ", status='" + status + '\'' +
                ", statusFacture='" + statusFacture + '\'' +
                ", rdvTypeName='" + rdvTypeName + '\'' +
                ", rdvTypePercent=" + rdvTypePercent +
                '}';
    }
}
