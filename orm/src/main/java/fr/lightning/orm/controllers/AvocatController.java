package fr.lightning.orm.controllers;

import fr.lightning.orm.daos.AvocatDao;
import fr.lightning.orm.models.Avocat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@CrossOrigin
public class AvocatController {
    @Autowired
    private AvocatDao avocatDao;

    @GetMapping(value = "avocats")
    public List<Avocat> getAllAvocats() {
        return avocatDao.findAll();
    }

    @GetMapping(value = "avocat/{id}")
    public Avocat getAvocatById(@PathVariable int id) {
        return avocatDao.findAvocatsById(id);
    }

    @PostMapping(value = "avocat")
    public String createAvocat(@RequestBody Avocat avocat) {
        Avocat avocat1 = avocatDao.save(avocat);
        if (avocat == null) {
            return "500";
        }

        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(avocat1.getId())
                .toUri();

        return "201";
    }
}
