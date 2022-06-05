package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Rol;
import com.app.elbuensabor.Servicio.RolServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class RolControlador {
    @Autowired
    RolServicio rolServicio;

    @GetMapping("/listarRoles")
    public List<Rol> listarRoles(){
        return rolServicio.listarRoles();
    }

    @GetMapping("/listarRolXId/{id}")
    public Optional<Rol> listarRolPorId(@PathVariable("id") int id){
        return rolServicio.listarRolPorId(id);
    }

    @PostMapping("/crearRol")
    public Rol crearRol(@RequestBody Rol rol){
        return rolServicio.guardarRol(rol);
    }

    @DeleteMapping("/borrarRol/{id}")
    public void borrarRol(@PathVariable("id") int id){
        rolServicio.borrarRol(id);
    }

    @PutMapping("/modificarRol")
    public Rol modificarRol(@RequestBody Rol rol){
        return rolServicio.modificarRol(rol);
    }
}

