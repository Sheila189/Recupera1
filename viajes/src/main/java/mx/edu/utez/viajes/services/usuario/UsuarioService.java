package mx.edu.utez.viajes.services.usuario;

import mx.edu.utez.viajes.models.usuario.UsuarioRepository;
import mx.edu.utez.viajes.models.usuario.Usuario;
import mx.edu.utez.viajes.utils.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    public Response getAll() {
        return new Response<List<Usuario>>(
                this.repository.findAll(),
                false,
                200,
                "OK"
        );
    }

    public Response getOne(Long id) {
        if (this.repository.existsById(id))
            return new Response<Usuario>(
                    this.repository.findById(id).get(),
                    false,
                    200,
                    "OK"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este Usuario"
        );
    }

    public Response insert(Usuario usuario) {
        if (this.repository.existsById(usuario.getId()))
            return new Response(
                    null,
                    true,
                    200,
                    "Usuario existente"
            );
        return new Response(
                this.repository.saveAndFlush(usuario),
                false,
                200,
                "Usuario registrado correctamente"
        );
    }

    public Response update(Usuario usuario) {
        if (this.repository.existsById(usuario.getId()))
            return new Response(
                    this.repository.saveAndFlush(usuario),
                    false,
                    200,
                    "Usuario actualizado correctamente"
            );
        return new Response(
                null,
                true,
                200,
                "No existe este Usuario"
        );
    }

    public Response delete(Long id) {
        if (this.repository.existsById(id)) {
            this.repository.deleteById(id);
            return new Response(
                    null,
                    false,
                    200,
                    "Usuario eliminado correctamente"
            );
        }
        return new Response(
                null,
                true,
                200,
                "No existe este Usuario"
        );
    }
}
