package fr.lightning.orm.controller;

import fr.lightning.orm.dao.FactureDao;
import fr.lightning.orm.dao.RdvDao;
import fr.lightning.orm.model.Factures;
import fr.lightning.orm.model.Rdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class FactureController {
    @Autowired
    private FactureDao factureDao;
    @Autowired
    private RdvDao rdvDao;

    @GetMapping(value = "factures")
    public List<Factures> getAllFactures() {
        return factureDao.findAll();
    }

    @GetMapping(value = "facture/facture:{id_facture}")
    public Factures getFactureById(@PathVariable int id_facture) {
        return factureDao.findFacturesByIdFacture(id_facture);
    }

    @GetMapping(value = "facturesByRdv/{id_rdv}")
    public List<Factures> getFacturesByIdRdv(@PathVariable int id_rdv) {
        Rdv rdv = rdvDao.getById(id_rdv);
        return factureDao.findFacturesByRdv(rdv);
    }

    @PostMapping(value = "facture/{id_rdv}")
    public ResponseEntity<Void> addFacture(@RequestBody Factures facture, @PathVariable int id_rdv) {
        Rdv rdv = rdvDao.getById(id_rdv);
        facture.setRdv(rdv);
        Factures facture1 = factureDao.save(facture);
        facture1.setRdv(rdv);
        if (facture == null) {
            return ResponseEntity.noContent().build();
        }
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(facture1.getId_facture())
                .toUri();

        return ResponseEntity.created(uri).build();
    }

    @PostMapping(value = "createFactureDatas")
    public void createFacturesDatas() {
        Rdv rdv = rdvDao.getById(1);
        Factures facture = new Factures(2, 10.50, 0, rdv);
        facture.setIdRdv(1);
        List<Factures> facturesList = new ArrayList<Factures>();
        facturesList.add(facture);
        factureDao.saveAll(facturesList);
    }
}
