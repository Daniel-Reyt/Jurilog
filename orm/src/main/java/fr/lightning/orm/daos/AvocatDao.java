package fr.lightning.orm.daos;

import fr.lightning.orm.models.Avocat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvocatDao extends JpaRepository<Avocat, Integer> {
    Avocat findAvocatsById(int id);
}
