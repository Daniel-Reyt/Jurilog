package fr.lightning.orm.daos;

import fr.lightning.orm.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDao extends JpaRepository<Facture, Integer> {
    Facture findFacturesById(int id);
    Facture findFactureByRdv_Id(int id_rdv);
}
