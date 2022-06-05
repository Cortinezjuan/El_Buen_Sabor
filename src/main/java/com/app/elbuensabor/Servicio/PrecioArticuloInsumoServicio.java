package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.PrecioArticuloInsumo;
import com.app.elbuensabor.Repositorio.PrecioArticuloInsumoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PrecioArticuloInsumoServicio {

    @Autowired
    PrecioArticuloInsumoRepositorio precioArticuloInsumoRepositorio;

    public List<PrecioArticuloInsumo> listarPreciosArtInsumo(){
        return precioArticuloInsumoRepositorio.findAll();
    }

    public Optional<PrecioArticuloInsumo> listarPrecioArtInsumoPorId(int id){
        return precioArticuloInsumoRepositorio.findById(id);
    }

    public PrecioArticuloInsumo guardarPrecioArtInsumo(PrecioArticuloInsumo precioArticuloInsumo){
        return precioArticuloInsumoRepositorio.save(precioArticuloInsumo);
    }

    public PrecioArticuloInsumo modificarPrecioArtInsumo(PrecioArticuloInsumo precioArticuloInsumo){
        return precioArticuloInsumoRepositorio.save(precioArticuloInsumo);
    }
}
