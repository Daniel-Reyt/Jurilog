package fr.lightning.orm.daos;

import fr.lightning.orm.models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {
    Client findClientsById(int id);
}
