package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Usuario;
import com.app.elbuensabor.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

    @GetMapping("/listarUsuarios")
    public List<Usuario> listarUsuarios(){
        return usuarioServicio.listarUsuarios();
    }

    @GetMapping("/listarUsuarioXId/{id}")
    public Optional<Usuario> listarUsuarioPorId(@PathVariable("id") int id){
        return usuarioServicio.listarUsuarioPorId(id);
    }

    @PostMapping("/crearUsuario")
    public Usuario crearUsuario(@RequestBody Usuario usuario){
        return usuarioServicio.guardarUsuario(usuario);
    }

    @DeleteMapping("/borrarUsuario/{id}")
    public void borrarUsuario(@PathVariable("id") int id){
        usuarioServicio.borrarUsuario(id);
    }

    @PutMapping("/modificarUsuario")
    public Usuario modificarUsuario(@RequestBody Usuario usuario){
        return usuarioServicio.modificarUsuario(usuario);
    }
}
