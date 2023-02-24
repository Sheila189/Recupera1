package mx.edu.utez.viajes.controllers.usuario.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.usuario.Usuario;
import mx.edu.utez.viajes.models.viaje.Viaje;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UsuarioDto {
    private Long id;
    private String name;
    private String email;
    private String fecha;
    private List<Viaje> viaje;

    public Usuario parseToUsuario() {
        return new Usuario(
                getId(),
                getName(),
                getEmail(),
                getFecha(),
                viaje
        );
    }
}
