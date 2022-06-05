package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.ArticuloManufacturado;
import com.app.elbuensabor.Repositorio.ArticuloManufacturadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloManufacturadoServicio {
    @Autowired
    ArticuloManufacturadoRepositorio articuloManufacturadoRepositorio;

    public List<ArticuloManufacturado> listarArticuloManufacturados(){
        return articuloManufacturadoRepositorio.listarArticuloManufacturados();
    }

    public Optional<ArticuloManufacturado> listarArticuloManufacturadoPorId(int id){
        return articuloManufacturadoRepositorio.findById(id);
    }

    public ArticuloManufacturado guardarArticuloManufacturado(ArticuloManufacturado articuloManufacturado){
        return articuloManufacturadoRepositorio.save(articuloManufacturado);
    }

    public void borrarArticuloManufacturado(int id){
        Optional<ArticuloManufacturado> articuloManufacturado = articuloManufacturadoRepositorio.findById(id);
        articuloManufacturado.get().setBajaArticuloManu(true);
        articuloManufacturadoRepositorio.save(articuloManufacturado.get());

    }

    public ArticuloManufacturado modificarArticuloManufacturado(ArticuloManufacturado articuloManufacturado){
        return articuloManufacturadoRepositorio.save(articuloManufacturado);
    }
}
