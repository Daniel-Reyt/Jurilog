package fr.lightning.orm.model;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Factures extends Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idFacture;
    @OneToOne(targetEntity = Rdv.class, fetch = FetchType.LAZY)
    private Rdv rdv;
    private int nb_heure;
    private double taux_honoraire;
    // 1 = payé // 0 = a payé
    private int status_facture;

    public Factures() {
    }

    public Factures(int nb_heure, double taux_honoraire, int status_facture, Rdv rdv) {
        this.setNb_heure(nb_heure);
        this.setTaux_honoraire(taux_honoraire);
        this.setStatus_facture(status_facture);
        this.setRdv(rdv);
    }

    //setters
    public int getId_facture() {
        return idFacture;
    }

    public void setId_facture(int id_facture) {
        this.idFacture = id_facture;
    }

    public void setIdRdv(int id_rdv) {
        this.rdv.setRdvId(id_rdv);
    }

    public void setNb_heure(int nb_heure) {
        this.nb_heure = nb_heure;
    }

    public void setTaux_honoraire(double taux_honoraire) {
        this.taux_honoraire = taux_honoraire;
    }

    public void setStatus_facture(int status_facture) {
        this.status_facture = status_facture;
    }

    public void setRdv(Rdv rdv) {
        this.rdv = rdv;
    }

    //getters
    public int getIdFacture() {
        return idFacture;
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

    public int getStatus_facture() {
        return status_facture;
    }
}
