package mx.edu.utez.viajes.models.viaje;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ViajeRepository extends
        JpaRepository<Viaje, Long> {
    boolean existsById(Long id);
}
