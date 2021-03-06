package fr.lightning.controllers;

import fr.lightning.daos.*;
import fr.lightning.entity.Client;
import fr.lightning.objects.BalanceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@RestController
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientDao clientDao;

    @Autowired
    private AvocatDao avocatDao;

    @Autowired
    private FactureDao factureDao;

    @Autowired
    private RdvDao rdvDao;

    @Autowired
    private TypeRdvDao typeRdvDao;

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
        clientDao.save(client);
        if (client != null) {
            return "201";
        } else {
            return "500";
        }
    }

    @GetMapping(value = "deleteAll")
    private void deleteAll() {
        factureDao.deleteAll();
        rdvDao.deleteAll();
        typeRdvDao.deleteAll();
        clientDao.deleteAll();
        avocatDao.deleteAll();
    }

    public List<Client> getClientForTest() {
        return clientDao.findAll();
    }
}
