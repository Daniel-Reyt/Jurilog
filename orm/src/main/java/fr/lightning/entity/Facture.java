package fr.lightning.entity;

import fr.lightning.job.FactureJob;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Facture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(targetEntity = Rdv.class, fetch = FetchType.LAZY)
    private Rdv rdv;
    private int nb_heure;
    @Column(nullable = true)
    private double taux_honoraire;
    // 1 = payé // 0 = a payé // null = pas de facture
    @Column(nullable = true)
    private String status_facture;

    public Facture() {
    }

    public Facture(FactureJob factureJob) {
        this.setNb_heure(factureJob.getNb_heure());
        this.setTaux_honoraire(factureJob.getTaux_honoraire());
        this.setStatus_facture(factureJob.getStatus_facture());
        this.setRdv(factureJob.getRdv());
    }

    //setters
    public void setId(int id) {
        this.id = id;
    }

    public void setRdv(Rdv rdv) {
        this.rdv = rdv;
    }

    public void setNb_heure(int nb_heure) {
        this.nb_heure = nb_heure;
    }

    public void setTaux_honoraire(double taux_honoraire) {
        this.taux_honoraire = taux_honoraire;
    }

    public void setStatus_facture(String status_facture) {
        this.status_facture = status_facture;
    }

    //getters
    public int getId() {
        return id;
    }

    public Rdv getRdv() {
        return rdv;
    }

    public int getNb_heure() {
        return nb_heure;
    }

    public double getTaux_honoraire() {
        return taux_honoraire;
    }

    public String getStatus_facture() {
        return status_facture;
    }

    //ToString
    @Override
    public String toString() {
        return "Facture{" +
                "id=" + id +
                ", rdv=" + rdv +
                ", nb_heure=" + nb_heure +
                ", taux_honoraire=" + taux_honoraire +
                ", status_facture=" + status_facture +
                '}';
    }
}
