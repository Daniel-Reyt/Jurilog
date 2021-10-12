package fr.lightning.daos;

import fr.lightning.entity.Rdv;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdvDao extends JpaRepository<Rdv, Integer> {
    Rdv findRdvById(int id);

    List<Rdv> findRdvsByAvocat_IdAndClient_Id(int idAvocat, int idClient);
    List<Rdv> findRdvsByAvocat_Id(int idAvocat);
    List<Rdv> findRdvsByClient_Id(int idClient);

    List<Rdv> findRdvsByIdAndClientId(int id, int idClient);
    List<Rdv> findRdvsByIdAndAvocatId(int id, int idAvocat);

    List<Rdv> findRdvsByDateAndClientId(String date, int idClient);
    List<Rdv> findRdvsByDateAndAvocatId(String date, int idAvocat);

    List<Rdv> findRdvByDate(String dateRdv);
    List<Rdv> findRdvsByAvocatIdAndDateEqualsAndHeureEquals(int idAvocat, String date, String heure);
    List<Rdv> findRdvsByStatusAndAvocatId(int status, int idAvocat);
    List<Rdv> findRdvsByStatusAndClientId(int status, int idClient);
}
