package fr.lightning.controllers;

import fr.lightning.daos.ClientDao;
import fr.lightning.entity.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;

@RestController
@CrossOrigin
public class ClientController {
    @Autowired
    private ClientDao clientDao;
    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @GetMapping(value = "clients")
    public List<Client> getAllClients() {
//        List<Client> clientList = clientDao.findAll();
//        for (int i = 0; i < clientList.size(); i++) {
//            String PasswordDecoded =
//        }
        return clientDao.findAll();
    }

    @GetMapping(value = "client/{id}")
    public Client getClientById(@PathVariable int id) {
        return clientDao.findClientById(id);
    }

    @PostMapping(value = "client")
    public String createClient(@RequestBody Client client) {
        String password = client.getPassword();
        String MotDePasseCrypte = passwordEncoder.encode(password);
        client.setPassword(MotDePasseCrypte);
        clientDao.save(client);
        if (client == null) {
            return "500";
        }

        return "201";
    }

    public List<Client> getClientForTest() {
        return clientDao.findAll();
    }
}
