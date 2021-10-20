package fr.lightning.daos;

import fr.lightning.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceDao extends JpaRepository<Balance, Integer> {
    Balance findBalanceByClient_Id(int idClient);
}
