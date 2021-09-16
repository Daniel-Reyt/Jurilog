package fr.lightning.orm.wrapper;

import fr.lightning.orm.models.Avocat;

import java.util.List;

public class AvocatWrapper {

    private List<Avocat> avocats;

    public List<Avocat> getAvocats() {
        return avocats;
    }

    public void setAvocats(List<Avocat> avocats) {
        this.avocats = avocats;
    }
}
