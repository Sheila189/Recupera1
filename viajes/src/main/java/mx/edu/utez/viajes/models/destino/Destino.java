package mx.edu.utez.viajes.models.destino;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.edu.utez.viajes.models.viaje.Viaje;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "destinos")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Destino {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String descripcion;
    private int precio;
    private int calificacion;
    private Integer disponibilidad;

    @OneToMany(mappedBy = "destino")
    private List<Viaje> viajes;
}
