package fr.lightning.daos;

import fr.lightning.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {
    Client findClientById(int id);
}
