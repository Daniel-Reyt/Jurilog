package fr.lightning.orm.wrapper;

import fr.lightning.orm.models.Facture;

import java.util.List;

public class FactureWrapper {

    private List<Facture> factures;

    public List<Facture> getFactures() {
        return factures;
    }

    public void setFactures(List<Facture> factures) {
        this.factures = factures;
    }
}
