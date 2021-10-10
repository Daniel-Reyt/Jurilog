package fr.lightning.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(targetEntity = Rdv.class, fetch = FetchType.LAZY)
    private Rdv rdv;
    private int nbHeure;
    @Column(nullable = true)
    private double tauxHonoraire;
    // 1 = payé // 0 = a payé // -1 = pas de facture
    private String statusFacture;
    private double totalFacture;

    public Facture() {
    }

    public Facture(int nbHeure, double tauxHonoraire, String statusFacture, Rdv rdv) {
        this.setNbHeure(nbHeure);
        this.setTauxHonoraire(tauxHonoraire);
        this.setStatusFacture(statusFacture);
        this.setRdv(rdv);
        this.calculTotal(nbHeure, tauxHonoraire, rdv.getType().getPercentAugmentation());
    }


    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setRdv(Rdv rdv) {
        this.rdv = rdv;
    }

    public void setNbHeure(int nbHeure) {
        this.nbHeure = nbHeure;
    }

    public void setTauxHonoraire(double tauxHonoraire) {
        this.tauxHonoraire = tauxHonoraire;
    }

    public void setStatusFacture(String statusFacture) {
        this.statusFacture = statusFacture;
    }

    //getters
    public int getId() {
        return id;
    }

    public Rdv getRdv() {
        return rdv;
    }

    public int getNbHeure() {
        return nbHeure;
    }

    public double getTauxHonoraire() {
        return tauxHonoraire;
    }

    public String getStatusFacture() {
        return statusFacture;
    }

    public double getTotalFacture() {
        return totalFacture;
    }

    public void calculTotal(int nbHeure, double tauxHonoraire, double percentAugmentation) {
        this.totalFacture = (nbHeure * tauxHonoraire) + ((nbHeure * tauxHonoraire) * (percentAugmentation / 100));
    }

    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", rdv=" + rdv +
                ", nb_heure=" + nbHeure +
                ", taux_honoraire=" + tauxHonoraire +
                ", status_facture='" + statusFacture + '\'' +
                ", total_facture=" + totalFacture +
                '}';
    }
}
