package pe.edu.upc.aww.werecycle.repositories;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pe.edu.upc.aww.werecycle.entities.Events;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface IEventsRepository extends JpaRepository<Events,Integer>{

    List<Events>findByDate(LocalDate date);
    List<Events> findByTitle(String title);

    @Query(value = "SELECT * FROM Events e JOIN Ubication u ON e.id_ubication = u.id_ubication WHERE u.city_ubication = :cityUbication", nativeQuery = true)
    List<Events> findEventsByUbication(@Param("cityUbication") String cityUbication);

    @Query( value = "SELECT * FROM Events e WHERE e.number_participant <30", nativeQuery = true )
    List<Events> cuposLibres();

    @Query (value= "SELECT COUNT (*) FROM Events e WHERE e.number_participant <30", nativeQuery = true)
    Integer countEventLibre();

    @Query (value = "SELECT u.city_ubication, COUNT(*) as cantidad_eventos\n" +
            "FROM events as e\n" +
            "INNER JOIN ubication as u\n" +
            "ON e.id_ubication = u.id_ubication\n" +
            "GROUP BY u.city_ubication;", nativeQuery = true)
    public List<String[]> numberofeventsperlocation();

    @Query(value = "SELECT e.* FROM Events e " +
            "JOIN Ubication u ON e.id_ubication = u.id_ubication " +
            "JOIN Useror uo ON uo.id_user = u.id_usuario " +
            "WHERE uo.id_user = :idUser", nativeQuery = true)
    List<Events> eventosDeUsuario(@Param("idUser") int idUser);

}
