package fr.lightning.orm.controller;

import fr.lightning.orm.dao.ClientDao;
import fr.lightning.orm.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class ClientController {

    @Autowired
    private ClientDao ClientDao;

    @GetMapping(value = "clients")
    public List<Clients> getAllClients() {
        return ClientDao.findAll();
    }

    @GetMapping(value = "client/{id_client}")
    public Clients getClient(@PathVariable int id_client) {
        System.out.println("get client id : " + id_client);
        return ClientDao.findByIdClient(id_client);
    }

    @PostMapping(value = "client")
    public String addClient(@RequestBody Clients client) {
        Clients client1 = ClientDao.save(client);
        if (client == null) {
            return "error";
        }
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client1.getId())
                .toUri();

        return "201";
    }

    @PostMapping(value = "createClientsDatas")
    public void createClientsDatas() {
        Clients client1 = new Clients("Reyt", "Daniel", "11 rue de la Gare 68500 Saint-Amarin", "00000000", "test", "test");
        Clients client2 = new Clients("Joultz", "Lucie", "14 rue du soleil 75000 Paris", "00000000", "test 2", "test 2");
        Clients client3 = new Clients("Hortie", "Lucas", "1 rue du marché 68000 Mulhouse", "00000000", "test 3", "test 3");

        List<Clients> clientsList = new ArrayList<Clients>();
        clientsList.add(client1);
        clientsList.add(client2);
        clientsList.add(client3);
        System.out.println(clientsList);
        ClientDao.saveAll(clientsList);
    }
}
