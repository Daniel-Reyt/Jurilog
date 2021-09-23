package fr.lightning.controllers;

import fr.lightning.daos.RdvDao;
import fr.lightning.models.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<Rdv> getRdvByIdAvocat_IdClient(@PathVariable int id_avocat, @PathVariable int id_client) {
        return rdvDao.findRdvsByAvocat_IdAndClient_Id(id_avocat, id_client);
    }

    @GetMapping(value = "rdvByIdRdvIdClient/{id_rdv}/{id_client}")
    public List<Rdv> getRdvByIdRdv_IdClient(@PathVariable int id_rdv, @PathVariable int id_client) {
        return rdvDao.findRdvsByIdAndClientId(id_rdv, id_client);
    }

    @GetMapping(value = "rdvByIdRdvIdAvocat/{id_rdv}/{id_avocat}")
    public List<Rdv> getRdvByIdRdv_IdAvocat(@PathVariable int id_rdv, @PathVariable int id_avocat) {
        return rdvDao.findRdvsByIdAndAvocatId(id_rdv, id_avocat);
    }

    @GetMapping(value = "rdvByDateRdvIdClient/{date}/{id_client}")
    public List<Rdv> getRdvByDateRdv_IdClient(@PathVariable String date, @PathVariable int id_client) {
        return rdvDao.findRdvsByDateAndClientId(date, id_client);
    }

    @GetMapping(value = "rdvByDateRdvIdAvocat/{date}/{id_avocat}")
    public List<Rdv> getRdvByDateRdv_IdAvocat(@PathVariable String date, @PathVariable int id_avocat) {
        return rdvDao.findRdvsByDateAndAvocatId(date, id_avocat);
    }

    @GetMapping(value = "rdvByDate/{date_rdv}")
    public List<Rdv> getRdvByDateRdv(@PathVariable String date_rdv) {
        System.out.println(date_rdv);
        return rdvDao.findRdvByDate(date_rdv);
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
