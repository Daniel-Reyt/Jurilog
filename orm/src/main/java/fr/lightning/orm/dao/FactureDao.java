package fr.lightning.orm.dao;

import fr.lightning.orm.model.Factures;
import fr.lightning.orm.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FactureDao extends JpaRepository<Factures, Integer> {
    Factures findFacturesByIdFacture(int id_facture);
    List<Factures> findFacturesByRdv(Rdv rdv);
}
