package fr.lightning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TypeRdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String typeRdvName;
    private double percentAugmentation;

    public TypeRdv() {
    }

    public TypeRdv(String typeRdvName, double percentAugmentation) {
        this.setTypeRdvName(typeRdvName);
        this.setPercentAugmentation(percentAugmentation);
    }

    public String getTypeRdvName() {
        return typeRdvName;
    }

    public void setTypeRdvName(String typeRdvName) {
        this.typeRdvName = typeRdvName;
    }

    public double getPercentAugmentation() {
        return percentAugmentation;
    }

    public void setPercentAugmentation(double percentAugmentation) {
        this.percentAugmentation = percentAugmentation;
    }

    @Override
    public String toString() {
        return "TypeRdv{" +
                "id=" + id +
                ", typeRdvName='" + typeRdvName + '\'' +
                ", percentAugmentation=" + percentAugmentation +
                '}';
    }
}
