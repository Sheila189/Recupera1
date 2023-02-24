package mx.edu.utez.viajes.models.viaje;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.destino.Destino;
import mx.edu.utez.viajes.models.usuario.Usuario;

import javax.persistence.*;

@Entity
@Table(name = "viajes")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String fechaSalida;
    private String fechaRegreso;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    @JsonIgnore
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_destino")
    @JsonIgnore
    private Destino destino;


}
