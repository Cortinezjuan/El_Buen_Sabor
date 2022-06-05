package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Usuario;
import com.app.elbuensabor.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;

    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.listarUsuarios();
    }

    public Optional<Usuario> listarUsuarioPorId(int id){
        return usuarioRepositorio.findById(id);
    }

    public Usuario guardarUsuario(Usuario Usuario){
        return usuarioRepositorio.save(Usuario);
    }

    public void borrarUsuario(int id){
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        usuario.get().setBajaUsuario(true);
        usuarioRepositorio.save(usuario.get());

    }

    public Usuario modificarUsuario(Usuario Usuario){
        return usuarioRepositorio.save(Usuario);
    }
}
