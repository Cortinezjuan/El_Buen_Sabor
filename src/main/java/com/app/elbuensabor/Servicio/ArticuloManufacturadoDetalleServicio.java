package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.ArticuloManufacturadoDetalleDto;
import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Entidad.ArticuloManufacturadoDetalle;
import com.app.elbuensabor.Repositorio.ArticuloManufacturadoDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloManufacturadoDetalleServicio {

    @Autowired
    ArticuloManufacturadoDetalleRepositorio amdRepositorio;

    public List<ArticuloManufacturadoDetalle> listarArticulosManuDetalle(){
        return amdRepositorio.findAll();
    }

    public Optional<ArticuloManufacturadoDetalle> listarArticulosManuDetallePorId(int id){
        return amdRepositorio.findById(id);
    }

    public ArticuloManufacturadoDetalle guardarArticuloManuDetalle(ArticuloManufacturadoDetalle articuloManufacturadoDetalle){
        return amdRepositorio.save(articuloManufacturadoDetalle);
    }

    public ArticuloManufacturadoDetalle modificarArticuloManuDetalle(ArticuloManufacturadoDetalle articuloManufacturadoDetalle){
        return amdRepositorio.save(articuloManufacturadoDetalle);
    }
}
