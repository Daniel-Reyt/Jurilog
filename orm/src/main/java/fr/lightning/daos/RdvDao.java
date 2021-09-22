package fr.lightning.daos;

import fr.lightning.models.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdvDao extends JpaRepository<Rdv, Integer> {
    Rdv findRdvById(int id);

    List<Rdv> findRdvsByAvocat_IdAndClient_Id(int id_avocat, int id_client);
    List<Rdv> findRdvsByAvocat_Id(int id_avocat);
    List<Rdv> findRdvsByClient_Id(int id_client);

    List<Rdv> findRdvsByIdAndClientId(int id, int id_client);
    List<Rdv> findRdvsByIdAndAvocatId(int id, int id_avocat);

    List<Rdv> findRdvsByDateAndClientId(String date, int id_client);
    List<Rdv> findRdvsByDateAndAvocatId(String date, int id_avocat);

    List<Rdv> findRdvByDate(String date_rdv);
}
