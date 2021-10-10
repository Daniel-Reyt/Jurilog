package fr.lightning.entity;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Rdv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String date;
    private String heure;
    @OneToOne(targetEntity = Client.class, fetch = FetchType.LAZY)
    private Client client;
    @OneToOne(targetEntity = Avocat.class, fetch = FetchType.LAZY)
    private Avocat avocat;
    @OneToOne(targetEntity = TypeRdv.class, fetch = FetchType.LAZY)
    private TypeRdv type;
    //1 = approved // 0 = en attente // 2 = refusé
    private int status;

    public Rdv() {
    }

    public Rdv(String dateRdv, String heureRdv, int status, Client client, Avocat avocat, TypeRdv typeRdv) {
        this.setDate(dateRdv);
        this.setHeure(heureRdv);
        this.setStatus(status);
        this.setClient(client);
        this.setAvocat(avocat);
        this.setType(typeRdv);
    }


    //setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(String dateRdv) {
        this.date = dateRdv;
    }

    public void setHeure(String heureRdv) {
        this.heure = heureRdv;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setAvocat(Avocat avocat) {
        this.avocat = avocat;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setType(TypeRdv typeRdv) {
        this.type = typeRdv;
    }

    //getters
    public String getDate() {
        return date;
    }

    public String getHeure() {
        return heure;
    }

    public Client getClient() {
        return client;
    }

    public Avocat getAvocat() {
        return avocat;
    }

    public int getStatus() {
        return status;
    }

    public TypeRdv getType() {
        return type;
    }

    //ToString / a update a chaque nouveau champs

    @Override
    public String toString() {
        return "Rdv{" +
                "id=" + id +
                ", date='" + date + '\'' +
                ", heure='" + heure + '\'' +
                ", client=" + client +
                ", avocat=" + avocat +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
