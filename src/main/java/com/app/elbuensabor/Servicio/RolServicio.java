package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Rol;
import com.app.elbuensabor.Repositorio.RolRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RolServicio {
    @Autowired
    RolRepositorio rolRepositorio;

    public List<Rol> listarRoles(){
        return rolRepositorio.listarRoles();
    }

    public Optional<Rol> listarRolPorId(int id){
        return rolRepositorio.findById(id);
    }

    public Rol guardarRol(Rol rol){
        return rolRepositorio.save(rol);
    }

    public void borrarRol(int id){
        Optional<Rol> rol = rolRepositorio.findById(id);
        rol.get().setBajaRol(true);
        rolRepositorio.save(rol.get());

    }

    public Rol modificarRol(Rol rol){
        return rolRepositorio.save(rol);
    }
}
