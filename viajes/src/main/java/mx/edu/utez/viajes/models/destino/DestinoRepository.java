package mx.edu.utez.viajes.models.destino;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DestinoRepository extends
        JpaRepository<Destino, Long> {
    boolean existsDestinoByName(String nombre);
}
