package pe.edu.upc.aww.werecycle.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aww.werecycle.entities.RecyclingCenter;
import pe.edu.upc.aww.werecycle.entities.Ubication;

import java.sql.Time;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface IURecyclingCenterRepository extends JpaRepository<RecyclingCenter, Integer> {
    List<RecyclingCenter>findRecyclingCenterByNameRecyclingCenter(String NameRecyclingCenter);

    List<RecyclingCenter>findRecyclingCenterByIdUbication(Ubication idUbication);

    List<RecyclingCenter>findRecyclingCenterByOpeninghourRecyclingCenter(Time openinghourRecyclingCenter);
    List<RecyclingCenter>findRecyclingCenterByClosingtimeRecyclingCenter(Time closingtimeRecyclingCenter);

    @Query(value = "SELECT e.* FROM Recycling_Center e " +
            "JOIN Ubication u ON e.id_ubication = u.id_ubication " +
            "JOIN Useror uo ON uo.id_user = u.id_usuario " +
            "WHERE uo.id_user = :idUser", nativeQuery = true)
    List<RecyclingCenter> centroDeUsuario(@Param("idUser") int idUser);

    @Query ("select count(r.nameRecyclingCenter) from RecyclingCenter r")
    public int cantidadCentro();
}
