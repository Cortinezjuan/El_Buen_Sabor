package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Configuracion;
import com.app.elbuensabor.Repositorio.ConfiguracionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ConfiguracionServicio {

    @Autowired
    ConfiguracionRepositorio configuracionRepositorio;

    public List<Configuracion> listarConfiguraciones(){
        return configuracionRepositorio.findAll();
    }

    public Optional<Configuracion> listarConfiguracionPorId(int id){
        return configuracionRepositorio.findById(id);
    }

    public Configuracion guardarConfiguracion(Configuracion configuracion){
        return configuracionRepositorio.save(configuracion);
    }

    public Configuracion modificarConfiguracion(Configuracion configuracion){
        return configuracionRepositorio.save(configuracion);
    }
}

