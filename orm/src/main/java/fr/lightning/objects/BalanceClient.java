package fr.lightning.objects;

public class BalanceClient {
    private String nom_client;
    private String prenom_client;
    private double balance_client;

    public BalanceClient() {
    }

    public BalanceClient(String nom_client, String prenom_client, double balance_client) {
        this.setNom_client(nom_client);
        this.setPrenom_client(prenom_client);
        this.setBalance_client(balance_client);
    }

    public String getNom_client() {
        return nom_client;
    }

    public void setNom_client(String nom_client) {
        this.nom_client = nom_client;
    }

    public String getPrenom_client() {
        return prenom_client;
    }

    public void setPrenom_client(String prenom_client) {
        this.prenom_client = prenom_client;
    }

    public double getBalance_client() {
        return balance_client;
    }

    public void setBalance_client(double balance_client) {
        this.balance_client = balance_client;
    }
}
