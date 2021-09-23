package fr.lightning.controllers;

import fr.lightning.daos.ClientDao;
import fr.lightning.models.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientDao clientDao;

    @GetMapping(value = "clients")
    public List<Client> getAllClients() {
        return clientDao.findAll();
    }

    @GetMapping(value = "client/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientDao.findClientById(id);
    }

    @PostMapping(value = "client")
    public String createClient(@RequestBody Client client) {
        Client client1 = clientDao.save(client);
        if (client == null) {
            return "500";
        }

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(client1.getId())
                .toUri();

        return "201";
    }

    public List<Client> getClientForTest() {
        return clientDao.findAll();
    }
}
