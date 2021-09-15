package fr.lightning.orm.controller;

import fr.lightning.orm.dao.AvocatDao;
import fr.lightning.orm.dao.ClientDao;
import fr.lightning.orm.dao.FactureDao;
import fr.lightning.orm.dao.RdvDao;
import fr.lightning.orm.model.Avocats;
import fr.lightning.orm.model.Clients;
import fr.lightning.orm.model.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin
@RestController
public class RdvController {
    @Autowired
    private RdvDao rdvDao;

    @Autowired
    private ClientDao clientDao;

    @Autowired
    private AvocatDao avocatDao;

    @Autowired
    private FactureDao factureDao;

    @GetMapping(value = "rdv")
    public List<Rdv> getAllRdv() {
        return rdvDao.findAll();
    }

    @GetMapping(value = "rdv/{id_rdv}")
    public Rdv getRdvById(@PathVariable int id_rdv) {
        return rdvDao.findRdvByRdvId(id_rdv);
    }

    @GetMapping(value = "rdvByIdAvocat/{id_avocat}")
    public List<Rdv> getAllRdvByIdAvocat(@PathVariable int id_avocat) {
        return rdvDao.findRdvByAvocat_AvocatId(id_avocat);
    }
    @GetMapping(value = "rdvByIdClient/{id_client}")
    public List<Rdv> getAllRdvByIdClient(@PathVariable int id_client) {
        return rdvDao.findRdvsByClient_IdClient(id_client);
    }
    @GetMapping(value = "rdv/{id_avocat}/{id_client}")
    public List<Rdv> getAllRdvByIdAvocatAndIdClient(@PathVariable int id_avocat, @PathVariable int id_client) {
        return rdvDao.findByAvocat_AvocatIdAndClient_IdClient(id_avocat, id_client);
    }

    @PostMapping(value = "rdv/{id_client}&{id_avocat}")
    public ResponseEntity<Void> addRdv(@RequestBody Rdv rdv, @PathVariable int id_client, @PathVariable int id_avocat) {
        Rdv rdv1 = rdv;
        Clients client = clientDao.findByIdClient(id_client);
        Avocats avocat = avocatDao.findByAvocatId(id_avocat);
        rdv.setStatus(0);
        rdv.setClient(client);
        rdv.setAvocat(avocat);
        rdvDao.save(rdv);
        if (rdv == null) {
            return ResponseEntity.noContent().build();
        }
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(rdv1.getRdvId())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PutMapping(value = "setStatusRdv")
    public void updateRdv(@RequestBody Rdv rdv) {
        rdvDao.updateSatatusRdvByRdvId(rdv.getStatus(), rdv.getRdvId());
        Rdv rdv1 = rdv;
        //rdvDao.save(rdv);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(rdv1.getRdvId())
                .toUri();
    }

    @PostMapping(value = "createRdvDatas")
    public void createRdvDatas() {
        Clients client = clientDao.findByIdClient(1);
        Avocats avocat = avocatDao.findByAvocatId(1);
        Rdv rdv = new Rdv(1, "10/01/2021", "10:30", 0, client, avocat);
        Rdv rdv1 = new Rdv(2, "20/01/2021", "20:30", 1, client, avocat);
        Rdv rdv2 = new Rdv(3, "30/01/2021", "30:30", 2, client, avocat);

        rdvDao.save(rdv);
        rdvDao.save(rdv1);
        rdvDao.save(rdv2);
    }
}
