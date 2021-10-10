package fr.lightning.controllers;

import fr.lightning.daos.TypeRdvDao;
import fr.lightning.entity.TypeRdv;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class TypeRdvController {
    @Autowired
    private TypeRdvDao typeRdvDao;

    @GetMapping(value = "typeRdvs")
    private List<TypeRdv> getAllTypeOfRdv() {
        return typeRdvDao.findAll();
    }
}
