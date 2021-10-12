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
    public Facture getFactureById(@PathVariable int id) {
        //new FrontFactureObject()
        return factureDao.findFacturesById(id);
    }

    @GetMapping(value = "factureByRdv/{idRdv}")
    public Facture getFactureByIdRdv(@PathVariable int idRdv) {
        //new FrontFactureObject()
        return factureDao.findFactureByRdv_Id(idRdv);
    }

    @PutMapping(value = "facture")
    public String createFacture(@RequestBody Facture facture) {
        Facture facture_to_update = factureDao.getById(facture.getId());
        if (facture_to_update.getStatusFacture().equals("-1")) {
            facture_to_update.setStatusFacture("0");
            facture_to_update.setNbHeure(facture.getNbHeure());
            facture_to_update.setTauxHonoraire(facture.getTauxHonoraire());
            facture_to_update.calculTotal(facture.getNbHeure(), facture.getTauxHonoraire(), facture.getRdv().getType().getPercentAugmentation());
            factureDao.save(facture_to_update);
        } else {
            factureDao.save(facture);
        }
        if (facture == null) {
            return "500";
        }

        return "201";
    }

}
