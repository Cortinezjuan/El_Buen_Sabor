package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Efectivo;
import com.app.elbuensabor.Entidad.Estado;
import com.app.elbuensabor.Repositorio.EstadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoServicio {
    @Autowired
    EstadoRepositorio estadoRepositorio;

    public List<Estado> listarEstados(){
        return estadoRepositorio.findAll();
    }

    public Optional<Estado> listarEstadoPorId(int id){
        return estadoRepositorio.findById(id);
    }

    public Estado guardarEstado(Estado estado){
        return estadoRepositorio.save(estado);
    }

    public Estado modificarEstado(Estado estado){
        return estadoRepositorio.save(estado);
    }
}
