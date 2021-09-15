package fr.lightning.orm.dao;

import fr.lightning.orm.model.Avocats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvocatDao extends JpaRepository<Avocats, Integer> {
    Avocats  findByAvocatId(int id);
}
