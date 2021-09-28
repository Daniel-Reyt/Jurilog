package fr.lightning.controllers;

import fr.lightning.daos.FactureDao;
import fr.lightning.entity.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class FactureController {
    @Autowired
    private FactureDao factureDao;

    @GetMapping(value = "factures")
    public List<Facture> getAllFactures() {
        return factureDao.findAll();
    }

    @GetMapping(value = "facture/{id}")
    public Facture getFactureById(@PathVariable int id) {
        return factureDao.findFacturesById(id);
    }

    @GetMapping(value = "factureByRdv/{idRdv}")
    public Facture getFactureByIdRdv(@PathVariable int idRdv) {
        return factureDao.findFactureByRdv_Id(idRdv);
    }

    @PostMapping(value = "facture")
    public String createFacture(@RequestBody Facture facture) {
        factureDao.save(facture);
        if (facture == null) {
            return "500";
        }

        return "201";
    }
}
