package fr.lightning.controllers;

import fr.lightning.daos.FactureDao;
import fr.lightning.entity.Facture;
import fr.lightning.objects.FrontFactureObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class FactureController {
    @Autowired
    private FactureDao factureDao;

    @GetMapping(value = "factures")
    public List<FrontFactureObject> getAllFactures() {
        List<FrontFactureObject> resultList = new ArrayList<>();
        List<Facture> facturesList = factureDao.findAll();

        for (int i = 0; i < facturesList.size(); i++) {
            FrontFactureObject factureObject = new FrontFactureObject(facturesList.get(i));
            resultList.add(factureObject);
        }

        return resultList;
    }

    @GetMapping(value = "facture/{id}")
    public FrontFactureObject getFactureById(@PathVariable int id) {
        return new FrontFactureObject(factureDao.findFacturesById(id));
    }

    @GetMapping(value = "factureByRdv/{idRdv}")
    public FrontFactureObject getFactureByIdRdv(@PathVariable int idRdv) {
        return new FrontFactureObject(factureDao.findFactureByRdv_Id(idRdv));
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
