package mx.edu.utez.viajes.services.viaje;

import mx.edu.utez.viajes.models.destino.DestinoRepository;
import mx.edu.utez.viajes.models.usuario.UsuarioRepository;
import mx.edu.utez.viajes.models.usuario.Usuario;
import mx.edu.utez.viajes.models.viaje.Viaje;
import mx.edu.utez.viajes.models.viaje.ViajeRepository;
import mx.edu.utez.viajes.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ViajeService {
    @Autowired
    private ViajeRepository repository;
    @Autowired
    private UsuarioRepository repository2;
    @Autowired
    private DestinoRepository repository3;

    public Response getAll() {
        return new Response<List<Viaje>>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public Response getOne(Long id) {
        return new Response<Object>(
                this.repository.findById(id),
                false,
                200,
                "OK"
        );
    }

    public Response insert(Viaje viaje) {
        if ( this.repository.existsById(viaje.getId()) && this.repository2.existsById(viaje.getUsuario().getId()) && this.repository3.existsDestinoByName(viaje.getDestino().getName()) )
            return new Response(
                    null,
                    true,
                    200,
                    "viaje existente"
            );
        return new Response(
                this.repository.saveAndFlush(viaje),
                false,
                200,
                "Vieje registrado correctamente"
        );
    }

    public Response update(Viaje viaje) {
        if (this.repository.existsById(viaje.getId()))
            return new Response(
                    this.repository.saveAndFlush(viaje),
                    false,
                    200,
                    "viaje actualizado correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este viaje"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "viaje eliminado correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe este viaje"
        );
    }
}
