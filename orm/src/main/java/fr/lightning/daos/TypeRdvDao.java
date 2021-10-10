package fr.lightning.daos;

import fr.lightning.entity.TypeRdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TypeRdvDao extends JpaRepository<TypeRdv, Integer> {
}
