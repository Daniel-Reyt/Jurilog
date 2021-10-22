package fr.lightning.entity;

import javax.persistence.*;

@Entity
public class BalanceAvocat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(targetEntity = Avocat.class, fetch = FetchType.LAZY)
    private Avocat avocat;
    private int montant;

    public BalanceAvocat(Avocat avocat, int montant) {
        this.setAvocat(avocat);
        this.setMontant(montant);
    }

    public BalanceAvocat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Avocat getAvocat() {
        return avocat;
    }

    public void setAvocat(Avocat avocat) {
        this.avocat = avocat;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
