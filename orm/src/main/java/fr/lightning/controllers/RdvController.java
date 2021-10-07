package fr.lightning.controllers;

import fr.lightning.daos.FactureDao;
import fr.lightning.daos.RdvDao;
import fr.lightning.entity.Facture;
import fr.lightning.entity.Rdv;
import fr.lightning.objects.FrontRdvObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class RdvController {
    @Autowired
    private RdvDao rdvDao;
    @Autowired
    private FactureDao factureDao;

    private String aPayer = "a payé";
    private String payer = "payé";
    private String pasDeFacture = "pas de facture";

    @GetMapping(value = "rdvs")
    public List<FrontRdvObject> getAllRdvs() {
        List<Rdv> rdvList = rdvDao.findAll();
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }

    @GetMapping(value = "rdv/{id}")
    public Rdv getRdvById(@PathVariable int id) {
        return rdvDao.findRdvById(id);
    }

    @GetMapping(value = "rdvByIdAvocatIdClient/{idAvocat}/{idClient}")
    public List<FrontRdvObject> getRdvByIdAvocatIdClient(@PathVariable int idAvocat, @PathVariable int idClient) {
        List<Rdv> rdvList = rdvDao.findRdvsByAvocat_IdAndClient_Id(idAvocat, idClient);
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }

    @GetMapping(value = "rdvByIdRdvIdClient/{idRdv}/{idClient}")
    public List<FrontRdvObject> getRdvByIdRdvIdClient(@PathVariable int idRdv, @PathVariable int idClient) {
        List<Rdv> rdvList = rdvDao.findRdvsByIdAndClientId(idRdv, idClient);
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }

    @GetMapping(value = "rdvByIdRdvIdAvocat/{idRdv}/{idAvocat}")
    public List<FrontRdvObject> getRdvByIdRdvIdAvocat(@PathVariable int idRdv, @PathVariable int idAvocat) {
        List<Rdv> rdvList = rdvDao.findRdvsByIdAndAvocatId(idRdv, idAvocat);
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }

    @GetMapping(value = "rdvByDateRdvIdClient/{date}/{idClient}")
    public List<FrontRdvObject> getRdvByDateRdvIdClient(@PathVariable String date, @PathVariable int idClient) {
        List<Rdv> rdvList = rdvDao.findRdvsByDateAndClientId(date, idClient);
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }

    @GetMapping(value = "rdvByDateRdvIdAvocat/{date}/{idAvocat}")
    public List<FrontRdvObject> getRdvByDateRdvIdAvocat(@PathVariable String date, @PathVariable int idAvocat) {
        List<Rdv> rdvList = rdvDao.findRdvsByDateAndAvocatId(date, idAvocat);
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }

    @GetMapping(value = "rdvByDate/{dateRdv}")
    public List<FrontRdvObject> getRdvByDateRdv(@PathVariable String dateRdv) {
        List<Rdv> rdvList = rdvDao.findRdvByDate(dateRdv);
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }

    @GetMapping(value = "rdvByIdAvocat/{idAvocat}")
    public List<FrontRdvObject> getRdvByIdAvocat(@PathVariable int idAvocat) {
        List<Rdv> rdvList = rdvDao.findRdvsByAvocat_Id(idAvocat);
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }
    //
    @GetMapping(value = "rdvByIdAvocatAndDateAndHour/{idAvocat}/{date}/{heure}")
    public List<FrontRdvObject> getRdvByIdAvocatAndDateAndHour(@PathVariable int idAvocat, @PathVariable String date, @PathVariable String heure) {
        List<Rdv> rdvList = rdvDao.findRdvsByAvocatIdAndDateEqualsAndHeureEquals(idAvocat, date, heure);
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }
    @GetMapping(value = "rdvByIdClient/{idClient}")
    public List<FrontRdvObject> getRdvByIdClient(@PathVariable int idClient) {
        List<Rdv> rdvList = rdvDao.findRdvsByClient_Id(idClient);
        List<FrontRdvObject> result = new ArrayList<>();
        for (Rdv rdv: rdvList) {
            Facture factures = factureDao.findFactureByRdv_Id(rdv.getId());
            FrontRdvObject frontRdvObject = new FrontRdvObject(rdv);
            frontRdvObject.setStatusFacture(checkFactures(factures));
            result.add(frontRdvObject);
        }
        return result;
    }

    @PostMapping(value = "rdv")
    public String createRdv(@RequestBody Rdv rdv) {
        rdvDao.save(rdv);
        factureDao.save(new Facture(1, 0, "-1", rdv));
        if (rdv != null) {
            return "201";
        } else {
            return "500";
        }
    }

    @PostMapping(value = "rdvValider")
    public String validerRdv(@RequestBody FrontRdvObject frontRdvObject) {
        Rdv rdv = rdvDao.getById(frontRdvObject.getId());
        rdv.setStatus(1);
        rdvDao.save(rdv);
        return "201";
    }

    @PostMapping(value = "rdvRefuser")
    public String refuserRdv(@RequestBody FrontRdvObject frontRdvObject) {
        Rdv rdv = rdvDao.getById(frontRdvObject.getId());
        rdv.setStatus(2);
        rdvDao.save(rdv);
        return "201";
    }

    private String checkFactures(Facture factures) {
        String statusFacture ="";
        if (factures != null) {
            if (factures.getStatusFacture().equals("-1")) {
                statusFacture = pasDeFacture;
            } else if (factures.getStatusFacture() == "1") {
                statusFacture = payer;
            } else if (factures.getStatusFacture() == "2") {
                statusFacture = aPayer;
            }
        } else {
            statusFacture = pasDeFacture;
        }
        return statusFacture;
    }
}
