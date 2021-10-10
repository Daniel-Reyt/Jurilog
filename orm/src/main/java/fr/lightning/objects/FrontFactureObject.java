package fr.lightning.objects;

import fr.lightning.entity.Facture;

public class FrontFactureObject {
    private String dateRdv;
    private String heureRdv;
    private int nbHeureRdv;
    private double tauxHonoraire;
    private double totalFacture;
    private String clientNom;
    private String clientPrenom;
    private String avocatNom;
    private String avocatPrenom;
    private String statusFacture;
    private int facture_id;

    public FrontFactureObject() {
    }

    public FrontFactureObject(Facture facture) {
        this.setDateRdv(facture.getRdv().getDate());
        this.setHeureRdv(facture.getRdv().getHeure());
        this.setNbHeureRdv(facture.getNbHeure());
        this.setTauxHonoraire(facture.getTauxHonoraire());
        this.setTotalFacture(facture.getTotalFacture());
        this.setClientNom(facture.getRdv().getClient().getNom());
        this.setClientPrenom(facture.getRdv().getClient().getPrenom());
        this.setAvocatNom(facture.getRdv().getAvocat().getNom());
        this.setAvocatPrenom(facture.getRdv().getAvocat().getPrenom());
        this.setStatusFacture(facture.getStatusFacture());
        this.setFacture_id(facture.getId());
    }

    public int getFacture_id() {
        return facture_id;
    }

    public void setFacture_id(int facture_id) {
        this.facture_id = facture_id;
    }

    public String getStatusFacture() {
        return statusFacture;
    }

    public void setStatusFacture(String statusFacture) {
        this.statusFacture = statusFacture;
    }

    public String getDateRdv() {
        return dateRdv;
    }

    public void setDateRdv(String dateRdv) {
        this.dateRdv = dateRdv;
    }

    public String getHeureRdv() {
        return heureRdv;
    }

    public void setHeureRdv(String heureRdv) {
        this.heureRdv = heureRdv;
    }

    public int getNbHeureRdv() {
        return nbHeureRdv;
    }

    public void setNbHeureRdv(int nbHeureRdv) {
        this.nbHeureRdv = nbHeureRdv;
    }

    public double getTauxHonoraire() {
        return tauxHonoraire;
    }

    public void setTauxHonoraire(double tauxHonoraire) {
        this.tauxHonoraire = tauxHonoraire;
    }

    public double getTotalFacture() {
        return totalFacture;
    }

    public void setTotalFacture(double totalFacture) {
        this.totalFacture = totalFacture;
    }

    public String getClientNom() {
        return clientNom;
    }

    public void setClientNom(String clientNom) {
        this.clientNom = clientNom;
    }

    public String getClientPrenom() {
        return clientPrenom;
    }

    public void setClientPrenom(String clientPrenom) {
        this.clientPrenom = clientPrenom;
    }

    public String getAvocatNom() {
        return avocatNom;
    }

    public void setAvocatNom(String avocatNom) {
        this.avocatNom = avocatNom;
    }

    public String getAvocatPrenom() {
        return avocatPrenom;
    }

    public void setAvocatPrenom(String avocatPrenom) {
        this.avocatPrenom = avocatPrenom;
    }
}
