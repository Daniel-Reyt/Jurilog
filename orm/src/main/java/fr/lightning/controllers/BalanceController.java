package fr.lightning.controllers;

import fr.lightning.daos.BalanceAvocatDao;
import fr.lightning.daos.BalanceDao;
import fr.lightning.entity.Balance;
import fr.lightning.entity.BalanceAvocat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BalanceController {
    @Autowired
    private BalanceDao balanceDao;
    @Autowired
    private BalanceAvocatDao balanceAvocatDao;

    @GetMapping(value = "getBalanceOfClient/{idClient}")
    private Balance getBalanceOfClient(@PathVariable int idClient) {
        return balanceDao.findBalanceByClient_Id(idClient);
    }
    @GetMapping(value = "getBalanceOfAvocat/{idAvocat}")
    private BalanceAvocat getBalanceOfAvocat(@PathVariable int idAvocat) {
        return balanceAvocatDao.findBalanceAvocatByAvocat_Id(idAvocat);
    }
    @PostMapping(value = "postNewMontantClient")
    private String postNewMontantOfBalanceOfClient(@RequestBody Balance balance) {
        balanceDao.save(balance);
        if (balance != null) {
            return "201";
        } else {
            return "500";
        }
    }
    @PostMapping(value = "postNewMontantAvocat")
    private String postNewMontantOfBalanceOfAvocat(@RequestBody BalanceAvocat balanceAvocat) {
        balanceAvocatDao.save(balanceAvocat);
        if (balanceAvocat != null) {
            return "201";
        } else {
            return "500";
        }
    }
    @PostMapping(value = "newBalanceClient")
    private String createNewBalanceClient(@RequestBody Balance balance) {
        balanceDao.save(balance);
        if (balance != null) {
            return "201";
        } else {
            return "500";
        }
    }
    @PostMapping(value = "newBalanceAvocat")
    private String createNewBalanceAvocat(@RequestBody BalanceAvocat balanceAvocat) {
        balanceAvocatDao.save(balanceAvocat);
        if (balanceAvocat != null) {
            return "201";
        } else {
            return "500";
        }
    }
}
