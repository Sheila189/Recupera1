package mx.edu.utez.viajes.controllers.viaje.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.destino.Destino;
import mx.edu.utez.viajes.models.usuario.Usuario;
import mx.edu.utez.viajes.models.viaje.Viaje;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ViajeDto {
    private Long id;
    private String fecha_salida;
    private String fecha_regreso;
    private Usuario usuario;
    private Destino destino;

    public Viaje parseToViaje() {
        return new Viaje(
                getId(),
                getFecha_salida(),
                getFecha_regreso(),
                usuario,
                destino
        );
    }
}
