package fr.lightning.controllers;

import fr.lightning.daos.BalanceDao;
import fr.lightning.entity.Balance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class BalanceController {
    @Autowired
    private BalanceDao balanceDao;

    @GetMapping(value = "getBalanceOfClient/{idClient}")
    private Balance getBalanceOfClient(@PathVariable int idClient) {
        return balanceDao.findBalanceByClient_Id(idClient);
    }

    @PostMapping(value = "postNewMontant")
    private String postNewMontantOfBalanceOfClient(@RequestBody Balance balance) {
        balanceDao.save(balance);
        if (balance != null) {
            return "201";
        } else {
            return "500";
        }
    }
    @PostMapping(value = "newBalance")
    private String createNewBalance(@RequestBody Balance balance) {
        balanceDao.save(balance);
        if (balance != null) {
            return "201";
        } else {
            return "500";
        }
    }
}
