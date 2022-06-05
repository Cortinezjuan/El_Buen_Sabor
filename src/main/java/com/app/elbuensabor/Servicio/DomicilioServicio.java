package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Domicilio;
import com.app.elbuensabor.Repositorio.DomicilioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServicio {

    @Autowired
    DomicilioRepositorio domicilioRepositorio;

    public List<Domicilio> listarDomicilios(){
        return domicilioRepositorio.listarDomicilios();
    }

    public Optional<Domicilio> listarDomicilioPorId(int id){
        return domicilioRepositorio.findById(id);
    }

    public Domicilio guardarDomicilio(Domicilio domicilio){
        return domicilioRepositorio.save(domicilio);
    }

    public void borrarDomicilio(int id){
        Optional<Domicilio> domicilio = domicilioRepositorio.findById(id);
        domicilio.get().setBajaDomicilio(true);
        domicilioRepositorio.save(domicilio.get());

    }

    public Domicilio modificarDomicilio(Domicilio domicilio){
        return domicilioRepositorio.save(domicilio);
    }
}
