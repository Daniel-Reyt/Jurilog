package fr.lightning.datas;

import fr.lightning.daos.AvocatDao;
import fr.lightning.daos.ClientDao;
import fr.lightning.daos.FactureDao;
import fr.lightning.daos.RdvDao;
import fr.lightning.models.Avocat;
import fr.lightning.models.Client;
import fr.lightning.models.Facture;
import fr.lightning.models.Rdv;
import fr.lightning.wrapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PostDatas {
    @Autowired
    private ClientDao clientDao;

    @Autowired
    private AvocatDao avocatDao;

    @Autowired
    private RdvDao rdvDao;

    @Autowired
    private FactureDao factureDao;

    @PostMapping(value = "postAvocatsDatas")
    public void createAvocatsDatas(@RequestBody AvocatWrapper avocatWrapper) {
        for (Avocat avocat: avocatWrapper.getAvocats()) {
            System.out.println(avocat);
            avocatDao.save(avocat);
        }
    }
    @PostMapping(value = "postClientsDatas")
    public void createClientsDatas(@RequestBody ClientWrapper clientWrapper) {
        for (Client client: clientWrapper.getClients()) {
            System.out.println(client);
            clientDao.save(client);
        }
    }
    @PostMapping(value = "postRdvsDatas")
    public void createRdvsDatas(@RequestBody RdvWrapper rdvWrapper) {
        for (Rdv rdv: rdvWrapper.getRdvs()) {
            System.out.println(rdv);
            rdvDao.save(rdv);
        }
    }
    @PostMapping(value = "postFacturesDatas")
    public void createFacturesDatas(@RequestBody FactureWrapper factureWrapper) {
        for (Facture facture: factureWrapper.getFactures()) {
            System.out.println(facture);
            factureDao.save(facture);
        }
    }
}
