package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.ArticuloManufacturadoDetalleDto;
import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Entidad.ArticuloManufacturado;
import com.app.elbuensabor.Entidad.ArticuloManufacturadoDetalle;
import com.app.elbuensabor.Entidad.RubroArticulo;
import com.app.elbuensabor.Repositorio.ArticuloManufacturadoDetalleRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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

    public ArticuloManufacturadoDetalleDto listarArticulosManuDetallePorId(int id){
        Optional<ArticuloManufacturadoDetalle> detalleOptional = amdRepositorio.findById(id);
        ArticuloManufacturadoDetalleDto articuloManufacturadoDetalle = new ArticuloManufacturadoDetalleDto();


        try {
            ArticuloManufacturadoDetalle Detalle2 = detalleOptional.get();

            articuloManufacturadoDetalle.setCantidadArticuloManuDetalle(Detalle2.getCantidadArticuloManuDetalle());
            articuloManufacturadoDetalle.setUnidadMedidaArticuloManuDetalle(Detalle2.getUnidadMedidaArticuloManuDetalle());
            try {
                ArticuloInsumo articuloInsumo = new ArticuloInsumo();

                articuloInsumo.setIdArticuloInsumo(Detalle2.getArticuloInsumo().getIdArticuloInsumo());
                articuloInsumo.setDenominacionArticuloInsumo(Detalle2.getArticuloInsumo().getDenominacionArticuloInsumo());
                articuloInsumo.setImagenArticuloInsumo(Detalle2.getArticuloInsumo().getImagenArticuloInsumo());
                articuloInsumo.setStockActual(Detalle2.getArticuloInsumo().getStockActual());
                articuloInsumo.setStockMinimo(Detalle2.getArticuloInsumo().getStockMinimo());
                articuloInsumo.setUnidadMedidaArticuloInsumo(Detalle2.getArticuloInsumo().getUnidadMedidaArticuloInsumo());
                articuloInsumo.setEsArticuloInsumo(Detalle2.getArticuloInsumo().isEsArticuloInsumo());
                articuloInsumo.setBajaArticuloInsumo(Detalle2.getArticuloInsumo().isBajaArticuloInsumo());


                try {
                    RubroArticulo rubroArticulo = new RubroArticulo();
                    rubroArticulo.setIdRubroArticulo(Detalle2.getArticuloInsumo().getRubroArticulo().getIdRubroArticulo());
                    //   rubroArticulo.setIdRubroArticulo(1);
                    articuloInsumo.setRubroArticulo(rubroArticulo);



                    //add
                    articuloManufacturadoDetalle.setArticuloInsumo(articuloInsumo);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }


            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            Detalle2.setIdArticuloManufacturadoDetalle(articuloManufacturadoDetalle.getIdArticuloManufacturadoDetalle());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return articuloManufacturadoDetalle;
    }


    public ArticuloManufacturadoDetalle guardarArticuloManuDetalle(ArticuloManufacturadoDetalle articuloManufacturadoDetalle){
        return amdRepositorio.save(articuloManufacturadoDetalle);
    }

    public ArticuloManufacturadoDetalleDto modificarArticuloManuDetalle(ArticuloManufacturadoDetalleDto articuloManufacturadoDetalleDto, int idArtMfDetalle){
        Optional<ArticuloManufacturadoDetalle> optional = amdRepositorio.findById(idArtMfDetalle);
        ArticuloManufacturadoDetalle articuloManufacturadoDetalle = new ArticuloManufacturadoDetalle();

        try {
            articuloManufacturadoDetalle = optional.get();

            articuloManufacturadoDetalle.setCantidadArticuloManuDetalle(articuloManufacturadoDetalleDto.getCantidadArticuloManuDetalle());
            articuloManufacturadoDetalle.setUnidadMedidaArticuloManuDetalle(articuloManufacturadoDetalleDto.getUnidadMedidaArticuloManuDetalle());
            try {
                ArticuloInsumo articuloInsumo = new ArticuloInsumo();

                articuloInsumo.setIdArticuloInsumo(articuloManufacturadoDetalleDto.getArticuloInsumo().getIdArticuloInsumo());
                articuloInsumo.setDenominacionArticuloInsumo(articuloManufacturadoDetalleDto.getArticuloInsumo().getDenominacionArticuloInsumo());
                articuloInsumo.setImagenArticuloInsumo(articuloManufacturadoDetalleDto.getArticuloInsumo().getImagenArticuloInsumo());
                articuloInsumo.setStockActual(articuloManufacturadoDetalleDto.getArticuloInsumo().getStockActual());
                articuloInsumo.setStockMinimo(articuloManufacturadoDetalleDto.getArticuloInsumo().getStockMinimo());
                articuloInsumo.setUnidadMedidaArticuloInsumo(articuloManufacturadoDetalleDto.getArticuloInsumo().getUnidadMedidaArticuloInsumo());
                articuloInsumo.setEsArticuloInsumo(articuloManufacturadoDetalleDto.getArticuloInsumo().isEsArticuloInsumo());
                articuloInsumo.setBajaArticuloInsumo(articuloManufacturadoDetalleDto.getArticuloInsumo().isBajaArticuloInsumo());


                try {
                    RubroArticulo rubroArticulo = new RubroArticulo();
                    rubroArticulo.setIdRubroArticulo(articuloManufacturadoDetalleDto.getArticuloInsumo().getRubroArticulo().getIdRubroArticulo());
                    //   rubroArticulo.setIdRubroArticulo(1);
                    articuloInsumo.setRubroArticulo(rubroArticulo);



                    //add
                    articuloManufacturadoDetalle.setArticuloInsumo(articuloInsumo);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            amdRepositorio.save(articuloManufacturadoDetalle);
            articuloManufacturadoDetalleDto.setIdArticuloManufacturadoDetalle(articuloManufacturadoDetalle.getIdArticuloManufacturadoDetalle());

        }catch (Exception e){
            System.out.println(e.getMessage());
        }

        return articuloManufacturadoDetalleDto;
    }
}


















