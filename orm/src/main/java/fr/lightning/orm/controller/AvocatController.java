package fr.lightning.orm.controller;

import fr.lightning.orm.dao.AvocatDao;
import fr.lightning.orm.model.Avocats;
import fr.lightning.orm.model.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
public class AvocatController {
    @Autowired
    private AvocatDao avocatDao;

    @GetMapping(value = "avocats")
    public List<Avocats> getAll() {
        return avocatDao.findAll();
    }

    @GetMapping(value = "avocat/{id_avocat}")
    public Avocats getAvocatById(@PathVariable int id_avocat) {
        System.out.println("get avocat id : " + id_avocat);
        return avocatDao.findByAvocatId(id_avocat);
    }

    @PostMapping(value = "avocat")
    public String addAvocats(@RequestBody Avocats avocat) {
        Avocats avocat1 = avocatDao.save(avocat);

        if (avocat == null) {
            return "error";
        }

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(avocat1.getId())
                .toUri();

        return "201";
    }

    @PostMapping(value = "createAvocatDatas")
    public void createAvocatDatas() {
        Avocats avocat1 = new Avocats("Pfaffren", "George", "1 rue des frères lumières 68000 Mulhouse", "00000000", "test", "test");
        Avocats avocat2 = new Avocats("Heitz" , "Louis", "24 rue de la houblonnière 68100 Colmar", "00000000", "test 2", "test 2");
        Avocats avocat3 = new Avocats("Arbert", "Jhon", "7 rue de la gare 68550 Saint-Amarin", "00000000", "test 3", "test 3");

        List<Avocats> avocatsList = new ArrayList<Avocats>();
        avocatsList.add(avocat1);
        avocatsList.add(avocat2);
        avocatsList.add(avocat3);

        avocatDao.saveAll(avocatsList);
    }
}
