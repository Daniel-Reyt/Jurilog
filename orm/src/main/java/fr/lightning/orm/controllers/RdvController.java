package fr.lightning.orm.controllers;

import fr.lightning.orm.daos.AvocatDao;
import fr.lightning.orm.daos.RdvDao;
import fr.lightning.orm.models.Avocat;
import fr.lightning.orm.models.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class RdvController {
    @Autowired
    private RdvDao rdvDao;

    @GetMapping(value = "rdvs")
    public List<Rdv> getAllRdvs() {
        return rdvDao.findAll();
    }

    @GetMapping(value = "rdv/{id}")
    public Rdv getRdvById(@PathVariable int id) {
        return rdvDao.findRdvById(id);
    }

    @GetMapping(value = "rdvByIdAvocatIdClient/{id_avocat}/{id_client}")
    public List<Rdv> getRdvByIdAvocat_IdClient(@PathVariable int id_avocat, int id_client) {
        return rdvDao.findRdvsByAvocat_IdAndClient_Id(id_avocat, id_client);
    }

    @GetMapping(value = "rdvByDate/{date_rdv}")
    public List<Rdv> getRdvByDateRdv(@PathVariable String date_rdv) {
        return rdvDao.findRdvsByDate(date_rdv);
    }

    @GetMapping(value = "rdvByIdAvocat/{id_avocat}")
    public List<Rdv> getRdvByIdAvocat(@PathVariable int id_avocat) {
        return rdvDao.findRdvsByAvocat_Id(id_avocat);
    }

    @GetMapping(value = "rdvByIdClient/{id_client}")
    public List<Rdv> getRdvByIdClient(@PathVariable int id_client) {
        return rdvDao.findRdvsByClient_Id(id_client);
    }

    @PostMapping(value = "rdv")
    public String createRdv(@RequestBody Rdv rdv) {
        Rdv rdv1 = rdvDao.save(rdv);
        if (rdv == null) {
            return "500";
        }

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(rdv1.getId())
                .toUri();

        return "201";
    }
}
