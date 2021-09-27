package fr.lightning.controllers;

import fr.lightning.daos.RdvDao;
import fr.lightning.models.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping(value = "rdvByIdAvocatIdClient/{idAvocat}/{idClient}")
    public List<Rdv> getRdvByIdAvocatIdClient(@PathVariable int idAvocat, @PathVariable int idClient) {
        return rdvDao.findRdvsByAvocat_IdAndClient_Id(idAvocat, idClient);
    }

    @GetMapping(value = "rdvByIdRdvIdClient/{idRdv}/{idClient}")
    public List<Rdv> getRdvByIdRdvIdClient(@PathVariable int idRdv, @PathVariable int idClient) {
        return rdvDao.findRdvsByIdAndClientId(idRdv, idClient);
    }

    @GetMapping(value = "rdvByIdRdvIdAvocat/{idRdv}/{idAvocat}")
    public List<Rdv> getRdvByIdRdvIdAvocat(@PathVariable int idRdv, @PathVariable int idAvocat) {
        return rdvDao.findRdvsByIdAndAvocatId(idRdv, idAvocat);
    }

    @GetMapping(value = "rdvByDateRdvIdClient/{date}/{idClient}")
    public List<Rdv> getRdvByDateRdvIdClient(@PathVariable String date, @PathVariable int idClient) {
        return rdvDao.findRdvsByDateAndClientId(date, idClient);
    }

    @GetMapping(value = "rdvByDateRdvIdAvocat/{date}/{idAvocat}")
    public List<Rdv> getRdvByDateRdvIdAvocat(@PathVariable String date, @PathVariable int idAvocat) {
        return rdvDao.findRdvsByDateAndAvocatId(date, idAvocat);
    }

    @GetMapping(value = "rdvByDate/{dateRdv}")
    public List<Rdv> getRdvByDateRdv(@PathVariable String dateRdv) {
        return rdvDao.findRdvByDate(dateRdv);
    }

    @GetMapping(value = "rdvByIdAvocat/{idAvocat}")
    public List<Rdv> getRdvByIdAvocat(@PathVariable int idAvocat) {
        return rdvDao.findRdvsByAvocat_Id(idAvocat);
    }

    @GetMapping(value = "rdvByIdClient/{idClient}")
    public List<Rdv> getRdvByIdClient(@PathVariable int idClient) {
        return rdvDao.findRdvsByClient_Id(idClient);
    }

    @PostMapping(value = "rdv")
    public String createRdv(@RequestBody Rdv rdv) {
        rdvDao.save(rdv);
        if (rdv == null) {
            return "500";
        }

        return "201";
    }
}
