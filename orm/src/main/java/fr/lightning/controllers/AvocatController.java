package fr.lightning.controllers;

import fr.lightning.daos.AvocatDao;
import fr.lightning.entity.Avocat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        avocatDao.save(avocat);
        if (avocat == null) {
            return "500";
        }
        return "201";
    }
}
