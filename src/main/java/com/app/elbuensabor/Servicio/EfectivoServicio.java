package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Efectivo;
import com.app.elbuensabor.Repositorio.EfectivoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EfectivoServicio {
    @Autowired
    EfectivoRepositorio efectivoRepositorio;

    public List<Efectivo> listarEfectivo(){
        return efectivoRepositorio.findAll();
    }

    public Optional<Efectivo> listarEfectivoPorId(int id){
        return efectivoRepositorio.findById(id);
    }

    public Efectivo guardarEfectivo(Efectivo efectivo){
        return efectivoRepositorio.save(efectivo);
    }

    public Efectivo modificarEfectivo(Efectivo efectivo){
        return efectivoRepositorio.save(efectivo);
    }
}
