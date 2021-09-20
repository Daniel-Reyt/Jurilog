package fr.lightning.orm.datas;

import fr.lightning.orm.daos.AvocatDao;
import fr.lightning.orm.daos.ClientDao;
import fr.lightning.orm.daos.FactureDao;
import fr.lightning.orm.daos.RdvDao;
import fr.lightning.orm.models.Avocat;
import fr.lightning.orm.models.Client;
import fr.lightning.orm.models.Facture;
import fr.lightning.orm.models.Rdv;
import fr.lightning.orm.wrapper.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
