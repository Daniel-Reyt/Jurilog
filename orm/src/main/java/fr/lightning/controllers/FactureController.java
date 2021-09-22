package fr.lightning.controllers;

import fr.lightning.daos.FactureDao;
import fr.lightning.models.Facture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @GetMapping(value = "factureByRdv/{id_rdv}")
    public Facture getFactureByIdRdv(@PathVariable int id_rdv) {
        return factureDao.findFactureByRdv_Id(id_rdv);
    }

    @PostMapping(value = "facture")
    public String createFacture(@RequestBody Facture facture) {
        Facture facture1 = factureDao.save(facture);
        if (facture == null) {
            return "500";
        }

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(facture1.getId())
                .toUri();

        return "201";
    }
}
