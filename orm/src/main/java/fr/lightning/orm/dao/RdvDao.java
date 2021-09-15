package fr.lightning.orm.dao;

import fr.lightning.orm.model.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RdvDao extends JpaRepository<Rdv, Integer> {
    Rdv findRdvByRdvId(int id_rdv);
    List<Rdv> findByAvocat_AvocatIdAndClient_IdClient(int avocat_id, int client_id);
    List<Rdv> findRdvByAvocat_AvocatId(int avocat_id);
    List<Rdv> findRdvsByClient_IdClient(int client_id);

    @Modifying
    @Query("update Rdv set status =:status where rdvId =:id")
    void updateSatatusRdvByRdvId(@Param("status") int status,
                          @Param("id") int id);
}
