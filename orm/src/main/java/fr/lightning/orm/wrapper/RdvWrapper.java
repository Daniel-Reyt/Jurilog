package fr.lightning.orm.wrapper;

import fr.lightning.orm.models.Rdv;

import java.util.List;

public class RdvWrapper {

    private List<Rdv> rdvs;

    public List<Rdv> getRdvs() {
        return rdvs;
    }

    public void setRdvs(List<Rdv> rdvs) {
        this.rdvs = rdvs;
    }
}
