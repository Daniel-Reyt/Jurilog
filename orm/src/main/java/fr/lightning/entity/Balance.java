package fr.lightning.entity;

import javax.persistence.*;

@Entity
public class Balance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @OneToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    private Client client;
    private int montant;

    public Balance(Client client, int montant) {
        this.setClient(client);
        this.setMontant(montant);
    }

    public Balance() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }
}
