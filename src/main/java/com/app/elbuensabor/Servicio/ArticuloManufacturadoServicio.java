package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.ArticuloManufacturadoDto;
import com.app.elbuensabor.Dto.CarritoDto;
import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Entidad.ArticuloManufacturado;
import com.app.elbuensabor.Entidad.ArticuloManufacturadoDetalle;
import com.app.elbuensabor.Repositorio.ArticuloInsumoRepositorio;
import com.app.elbuensabor.Repositorio.ArticuloManufacturadoRepositorio;
import com.app.elbuensabor.Repositorio.PrecioArticuloManufacturadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticuloManufacturadoServicio {
    @Autowired
    ArticuloManufacturadoRepositorio articuloManufacturadoRepositorio;

    @Autowired
    PrecioArticuloManufacturadoRepositorio precioArticuloManufacturadoRepositorio;

    @Autowired
    ArticuloInsumoRepositorio articuloInsumoRepositorio;

    public List<ArticuloManufacturadoDto> listarArticuloManufacturados(){
        List<ArticuloManufacturadoDto> articulosDto = new ArrayList<>();
        List <ArticuloManufacturado> articulos = articuloManufacturadoRepositorio.listarArticuloManufacturados();

        for(ArticuloManufacturado aux: articulos){
            List<String> insumos = new ArrayList<>();
            int stockMinimo = 1000;
            for(ArticuloManufacturadoDetalle auxDetalle: aux.getArticuloManufacturadoDetalles()){
                  int stockActual = articuloInsumoRepositorio.findStockByIdArticuloInsumo(auxDetalle.getArticuloInsumo().getIdArticuloInsumo());
                  int cantidadAPreparar = stockActual*1000/auxDetalle.getCantidadArticuloManuDetalle();
                  if(cantidadAPreparar<stockMinimo){
                      stockMinimo = cantidadAPreparar;
                  }
                  insumos.add(auxDetalle.getArticuloInsumo().getDenominacionArticuloInsumo());
            }

            if(stockMinimo > 0){
                Double precioArticulo = precioArticuloManufacturadoRepositorio.findByIdArticuloManufacturado(aux.getIdArticuloManufacturado());

                ArticuloManufacturadoDto auxDto = ArticuloManufacturadoDto.builder()
                        .imagenArticuloManu(aux.getImagenArticuloManu())
                        .idArticuloManufacturado(aux.getIdArticuloManufacturado())
                        .denominacionArticuloManu(aux.getDenominacionArticuloManu())
                        .tiempoEstimadoCocina(aux.getTiempoEstimadoCocina())
                        .precioTotal(precioArticulo)
                        .stock(stockMinimo)
                        .insumos(insumos)
                        .build();
                articulosDto.add(auxDto);
            }

        }
        return articulosDto;
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

    public List<CarritoDto> descontarStock(List<CarritoDto> carritosDto){
        for(CarritoDto aux: carritosDto){
            Optional<ArticuloManufacturado> articulo = articuloManufacturadoRepositorio.findById(aux.getId());
            for(ArticuloManufacturadoDetalle insumo: articulo.get().getArticuloManufacturadoDetalles()){
                double proporcion = insumo.getCantidadArticuloManuDetalle();
                double cantADescontar = proporcion * aux.getCantidad();
                double stockOriginal = insumo.getArticuloInsumo().getStockActual();
                double stockActual = stockOriginal - cantADescontar/1000;
                insumo.getArticuloInsumo().setStockActual(stockActual);
                articuloInsumoRepositorio.save(insumo.getArticuloInsumo());
            }
        }
        return carritosDto;
    }
}
