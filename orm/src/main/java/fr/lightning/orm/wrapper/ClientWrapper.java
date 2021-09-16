package fr.lightning.orm.wrapper;

import fr.lightning.orm.models.Client;

import java.util.List;

public class ClientWrapper {

    private List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
