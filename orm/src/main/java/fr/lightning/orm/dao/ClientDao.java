package fr.lightning.orm.dao;

import fr.lightning.orm.model.Clients;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Clients, Integer> {
    Clients findByIdClient(int id);

}
