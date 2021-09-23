package fr.lightning.wrapper;

import fr.lightning.wrapper.AvocatWrapper;

import java.util.List;

public class BodyWrapper {

    private AvocatWrapper avocatWrapper;
    private ClientWrapper clientWrapper;
    private RdvWrapper rdvWrapper;
    private FactureWrapper factureWrapper;

    public AvocatWrapper getAvocatWrapper() {
        return avocatWrapper;
    }

    public void setAvocatWrapper(AvocatWrapper avocatWrapper) {
        this.avocatWrapper = avocatWrapper;
    }

    public ClientWrapper getClientWrapper() {
        return clientWrapper;
    }

    public void setClientWrapper(ClientWrapper clientWrapper) {
        this.clientWrapper = clientWrapper;
    }

    public RdvWrapper getRdvWrapper() {
        return rdvWrapper;
    }

    public void setRdvWrapper(RdvWrapper rdvWrapper) {
        this.rdvWrapper = rdvWrapper;
    }

    public FactureWrapper getFactureWrapper() {
        return factureWrapper;
    }

    public void setFactureWrapper(FactureWrapper factureWrapper) {
        this.factureWrapper = factureWrapper;
    }
}
