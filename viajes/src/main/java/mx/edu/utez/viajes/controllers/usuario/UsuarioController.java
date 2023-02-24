package mx.edu.utez.viajes.controllers.usuario;

import mx.edu.utez.viajes.controllers.usuario.dtos.UsuarioDto;
import mx.edu.utez.viajes.services.usuario.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api-viaje/Usuario")
@CrossOrigin(origins = {"*"})
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public ResponseEntity getAll() {
        return new ResponseEntity(
                this.service.getAll(),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity getOne(
            @PathVariable("id") Long id
    ) {
        System.out.println(id);
        return new ResponseEntity(
                this.service.getOne(id),
                HttpStatus.OK
        );
    }

    @PostMapping("/")
    public ResponseEntity save(
            @RequestBody UsuarioDto usuario
    ) {
        return new ResponseEntity(
                this.service.insert(usuario.parseToUsuario()),
                HttpStatus.CREATED
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity update(
            @PathVariable Long id,
            @RequestBody UsuarioDto usuario
    ) {
        usuario.setId(id);
        return new ResponseEntity(
                this.service.update(usuario.parseToUsuario()),
                HttpStatus.OK
        );
    }
    @DeleteMapping("/{id}")
    public ResponseEntity delete(
            @PathVariable("id") long id
    ) {
        return new ResponseEntity(
                this.service.delete(id),
                HttpStatus.OK
        );
    }
}
