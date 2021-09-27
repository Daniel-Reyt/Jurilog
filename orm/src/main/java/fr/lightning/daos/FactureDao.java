package fr.lightning.daos;

import fr.lightning.models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FactureDao extends JpaRepository<Facture, Integer> {
    Facture findFacturesById(int id);
    Facture findFactureByRdv_Id(int idRdv);
}
