package fr.lightning.daos;

import fr.lightning.entity.BalanceAvocat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BalanceAvocatDao extends JpaRepository<BalanceAvocat, Integer> {
    BalanceAvocat findBalanceAvocatByAvocat_Id(int idAvocat);
}
