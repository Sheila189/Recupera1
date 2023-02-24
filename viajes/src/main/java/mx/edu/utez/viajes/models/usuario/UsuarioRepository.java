package mx.edu.utez.viajes.models.usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends
        JpaRepository<Usuario, Long> {
    boolean existsById(Long id);
}
