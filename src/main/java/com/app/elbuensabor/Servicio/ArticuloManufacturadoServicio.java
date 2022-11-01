package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.*;
import com.app.elbuensabor.Entidad.*;
import com.app.elbuensabor.Repositorio.ArticuloInsumoRepositorio;
import com.app.elbuensabor.Repositorio.ArticuloManufacturadoRepositorio;
import com.app.elbuensabor.Repositorio.PrecioArticuloManufacturadoRepositorio;
import org.modelmapper.internal.asm.tree.TryCatchBlockNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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

    public List<ArticuloManufacturadoDto> listarArticuloManufacturados() {
        List<ArticuloManufacturadoDto> articulosDto = new ArrayList<>();
        List<ArticuloManufacturado> articulos = articuloManufacturadoRepositorio.listarArticuloManufacturados();

        for (ArticuloManufacturado aux : articulos) {
            List<String> insumos = new ArrayList<>();
            int stockMinimo = 1000;
            try {
                for (ArticuloManufacturadoDetalle auxDetalle : aux.getArticuloManufacturadoDetalles()) {
                    double stockActual = articuloInsumoRepositorio.findStockByIdArticuloInsumo(auxDetalle.getArticuloInsumo().getIdArticuloInsumo());
                    double cantidadAPreparar = stockActual * 1000.0 / auxDetalle.getCantidadArticuloManuDetalle();
                    if (cantidadAPreparar < stockMinimo) {
                        stockMinimo = (int) cantidadAPreparar;
                    }
                    insumos.add(auxDetalle.getArticuloInsumo().getDenominacionArticuloInsumo());
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            RubroGeneral rubroGeneral = new RubroGeneral();
            rubroGeneral.setIdRubroGeneral(aux.getRubroGeneral().getIdRubroGeneral());
            rubroGeneral.setDenominacionRubroGeneral(aux.getRubroGeneral().getDenominacionRubroGeneral());


            if (stockMinimo > 0) {


                try {
                    List<PrecioArticuloManufacturado> precios = new ArrayList<>();

                    for (PrecioArticuloManufacturado precioArt : aux.getPrecioArticuloManufacturados()) {

                        PrecioArticuloManufacturado precioArticuloManufacturado = new PrecioArticuloManufacturado();
                        precioArticuloManufacturado.setIdPrecioArticuloManufacturado(precioArt.getIdPrecioArticuloManufacturado());
                        precioArticuloManufacturado.setPrecioCostoArticuloManufacturado(precioArt.getPrecioCostoArticuloManufacturado());
                        precioArticuloManufacturado.setPrecioVentaArticuloManufacturado(precioArt.getPrecioVentaArticuloManufacturado());
                        precioArticuloManufacturado.setFechaPrecioArtManu(precioArt.getFechaPrecioArtManu());
                        precioArticuloManufacturado.setCantidadPrecioArtManu(precioArt.getCantidadPrecioArtManu());

                        precios.add(precioArticuloManufacturado);
                    }
                    aux.setPrecioArticuloManufacturados(precios);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                ArticuloManufacturadoDto auxDto = ArticuloManufacturadoDto.builder().imagenArticuloManu(aux.getImagenArticuloManu()).idArticuloManufacturado(aux.getIdArticuloManufacturado()).denominacionArticuloManu(aux.getDenominacionArticuloManu()).tiempoEstimadoCocina(aux.getTiempoEstimadoCocina()).preciosArticulosManufacturados(aux.getPrecioArticuloManufacturados()).stock(stockMinimo).insumos(insumos).rubroGeneral(rubroGeneral).build();
                articulosDto.add(auxDto);
            }
        }
        return articulosDto;
    }

    public Optional<ArticuloManufacturado> listarArticuloManufacturadoPorId(int id) {
        return articuloManufacturadoRepositorio.findById(id);
    }

    public void borrarArticuloManufacturado(int id) {
        Optional<ArticuloManufacturado> articuloManufacturado = articuloManufacturadoRepositorio.findById(id);
        articuloManufacturado.get().setBajaArticuloManu(true);
        articuloManufacturadoRepositorio.save(articuloManufacturado.get());

    }


    public List<CarritoDto> descontarStock(List<CarritoDto> carritosDto) {
        for (CarritoDto aux : carritosDto) {
            Optional<ArticuloManufacturado> articulo = articuloManufacturadoRepositorio.findById(aux.getId());
            for (ArticuloManufacturadoDetalle insumo : articulo.get().getArticuloManufacturadoDetalles()) {
                double proporcion = insumo.getCantidadArticuloManuDetalle();
                double cantADescontar = proporcion * aux.getCantidad();
                double stockOriginal = insumo.getArticuloInsumo().getStockActual();
                double stockActual = stockOriginal - cantADescontar / 1000.0;
                insumo.getArticuloInsumo().setStockActual(stockActual);
                articuloInsumoRepositorio.save(insumo.getArticuloInsumo());
            }
        }
        return carritosDto;
    }


    //-----------------------------Métodos para ArticuloMFRubroDto------------------------------
    public List<ArticuloMFRubroDto> listarArticuloManufacturadosRubro() {
        List<ArticuloMFRubroDto> articulosDto = new ArrayList<>();
        List<ArticuloManufacturado> articulos = articuloManufacturadoRepositorio.listarArticuloManufacturados();

        for (ArticuloManufacturado aux : articulos) {

            RubroGeneral rubroGeneral = new RubroGeneral();
            rubroGeneral.setIdRubroGeneral(aux.getRubroGeneral().getIdRubroGeneral());
            rubroGeneral.setDenominacionRubroGeneral(aux.getRubroGeneral().getDenominacionRubroGeneral());


            List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new ArrayList<>();

            for (ArticuloManufacturadoDetalle auxDetalle : aux.getArticuloManufacturadoDetalles()) {

                ArticuloManufacturadoDetalle artMFdetalle = new ArticuloManufacturadoDetalle();
                artMFdetalle.setIdArticuloManufacturadoDetalle(auxDetalle.getIdArticuloManufacturadoDetalle());
                artMFdetalle.setCantidadArticuloManuDetalle(auxDetalle.getCantidadArticuloManuDetalle());
                artMFdetalle.setUnidadMedidaArticuloManuDetalle(auxDetalle.getUnidadMedidaArticuloManuDetalle());

                try {

                    ArticuloInsumo artInsumo = new ArticuloInsumo();

                    artInsumo.setIdArticuloInsumo(auxDetalle.getArticuloInsumo().getIdArticuloInsumo());
                    artInsumo.setDenominacionArticuloInsumo(auxDetalle.getArticuloInsumo().getDenominacionArticuloInsumo());

                    artInsumo.setImagenArticuloInsumo(auxDetalle.getArticuloInsumo().getImagenArticuloInsumo());
                    artInsumo.setStockActual(auxDetalle.getArticuloInsumo().getStockActual());
                    artInsumo.setStockMinimo(auxDetalle.getArticuloInsumo().getStockMinimo());
                    artInsumo.setUnidadMedidaArticuloInsumo(auxDetalle.getArticuloInsumo().getUnidadMedidaArticuloInsumo());
                    artInsumo.setEsArticuloInsumo(auxDetalle.getArticuloInsumo().isEsArticuloInsumo());
                    artInsumo.setBajaArticuloInsumo(auxDetalle.getArticuloInsumo().isBajaArticuloInsumo());

                    try {
                        List<PrecioArticuloInsumo> precios = new ArrayList<>();

                        for (PrecioArticuloInsumo precioArt : auxDetalle.getArticuloInsumo().getPreciosArticulosInsumo()) {
                            PrecioArticuloInsumo precioArticuloInsumo = new PrecioArticuloInsumo();
                            precioArticuloInsumo.setIdPrecio(precioArt.getIdPrecio());
                            precioArticuloInsumo.setPrecioCostoArticuloInsumo(precioArt.getPrecioCostoArticuloInsumo());
                            precioArticuloInsumo.setPrecioVentaArticuloInsumo(precioArt.getPrecioVentaArticuloInsumo());
                            precioArticuloInsumo.setFechaPrecioArtInsumo(precioArt.getFechaPrecioArtInsumo());
                            precioArticuloInsumo.setCantidadPrecioArtInsumo(precioArt.getCantidadPrecioArtInsumo());

                            precios.add(precioArticuloInsumo);
                        }
                        auxDetalle.getArticuloInsumo().setPreciosArticulosInsumo(precios);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    //Seteo el RubroArticulo del Insumo
                    try {
                        RubroArticulo rubro = new RubroArticulo();

                        rubro.setIdRubroArticulo(auxDetalle.getArticuloInsumo().getIdArticuloInsumo());
                        rubro.setDenominacionRubroArticulo(auxDetalle.getArticuloInsumo().getRubroArticulo().getDenominacionRubroArticulo());
                        //rubro.setRubroArticuloPadre(articulo2.getRubroArticulo());

                        auxDetalle.getArticuloInsumo().setRubroArticulo(rubro);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    artMFdetalle.setArticuloInsumo(artInsumo);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                articuloManufacturadoDetalles.add(artMFdetalle);

            }


            int stockMinimo = 1000;
            if (stockMinimo > 0) {
                try {
                    List<PrecioArticuloManufacturado> precios = new ArrayList<>();

                    for (PrecioArticuloManufacturado precioArt : aux.getPrecioArticuloManufacturados()) {

                        PrecioArticuloManufacturado precioArticuloManufacturado = new PrecioArticuloManufacturado();
                        precioArticuloManufacturado.setIdPrecioArticuloManufacturado(precioArt.getIdPrecioArticuloManufacturado());
                        precioArticuloManufacturado.setPrecioCostoArticuloManufacturado(precioArt.getPrecioCostoArticuloManufacturado());
                        precioArticuloManufacturado.setPrecioVentaArticuloManufacturado(precioArt.getPrecioVentaArticuloManufacturado());
                        precioArticuloManufacturado.setFechaPrecioArtManu(precioArt.getFechaPrecioArtManu());
                        precioArticuloManufacturado.setCantidadPrecioArtManu(precioArt.getCantidadPrecioArtManu());

                        precios.add(precioArticuloManufacturado);
                    }
                    aux.setPrecioArticuloManufacturados(precios);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                aux.setArticuloManufacturadoDetalles(articuloManufacturadoDetalles);


                ArticuloMFRubroDto auxDto2 = ArticuloMFRubroDto.builder().imagenArticuloManu(aux.getImagenArticuloManu()).idArticuloManufacturado(aux.getIdArticuloManufacturado()).denominacionArticuloManu(aux.getDenominacionArticuloManu()).tiempoEstimadoCocina(aux.getTiempoEstimadoCocina()).preciosArticulosManufacturados(aux.getPrecioArticuloManufacturados()).stock(stockMinimo).articuloManufacturadoDetalles(aux.getArticuloManufacturadoDetalles()).rubroGeneral(rubroGeneral).build();
                articulosDto.add(auxDto2);
            }

        }
        return articulosDto;
    }

    public ArticuloMFRubroDto listarArticuloMFPorId(int id) {
        Optional<ArticuloManufacturado> manufacturadoOptional = articuloManufacturadoRepositorio.findById(id);
        ArticuloMFRubroDto aux1 = new ArticuloMFRubroDto();

        try {
            ArticuloManufacturado aux = manufacturadoOptional.get();

            RubroGeneral rubroGeneral = new RubroGeneral();
            rubroGeneral.setIdRubroGeneral(aux.getRubroGeneral().getIdRubroGeneral());
            rubroGeneral.setDenominacionRubroGeneral(aux.getRubroGeneral().getDenominacionRubroGeneral());


            List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new ArrayList<>();

            for (ArticuloManufacturadoDetalle auxDetalle : aux.getArticuloManufacturadoDetalles()) {
                ArticuloManufacturadoDetalle artMFdetalle = new ArticuloManufacturadoDetalle();

                artMFdetalle.setIdArticuloManufacturadoDetalle(auxDetalle.getIdArticuloManufacturadoDetalle());
                artMFdetalle.setCantidadArticuloManuDetalle(auxDetalle.getCantidadArticuloManuDetalle());
                artMFdetalle.setUnidadMedidaArticuloManuDetalle(auxDetalle.getUnidadMedidaArticuloManuDetalle());

                try {

                    ArticuloInsumo artInsumo = new ArticuloInsumo();

                    artInsumo.setIdArticuloInsumo(auxDetalle.getArticuloInsumo().getIdArticuloInsumo());
                    artInsumo.setDenominacionArticuloInsumo(auxDetalle.getArticuloInsumo().getDenominacionArticuloInsumo());

                    artInsumo.setImagenArticuloInsumo(auxDetalle.getArticuloInsumo().getImagenArticuloInsumo());
                    artInsumo.setStockActual(auxDetalle.getArticuloInsumo().getStockActual());
                    artInsumo.setStockMinimo(auxDetalle.getArticuloInsumo().getStockMinimo());
                    artInsumo.setUnidadMedidaArticuloInsumo(auxDetalle.getArticuloInsumo().getUnidadMedidaArticuloInsumo());
                    artInsumo.setEsArticuloInsumo(auxDetalle.getArticuloInsumo().isEsArticuloInsumo());
                    artInsumo.setBajaArticuloInsumo(auxDetalle.getArticuloInsumo().isBajaArticuloInsumo());

                    try {
                        List<PrecioArticuloInsumo> precios = new ArrayList<>();

                        for (PrecioArticuloInsumo precioArt : auxDetalle.getArticuloInsumo().getPreciosArticulosInsumo()) {
                            PrecioArticuloInsumo precioArticuloInsumo = new PrecioArticuloInsumo();

                            precioArticuloInsumo.setIdPrecio(precioArt.getIdPrecio());
                            precioArticuloInsumo.setPrecioCostoArticuloInsumo(precioArt.getPrecioCostoArticuloInsumo());
                            precioArticuloInsumo.setPrecioVentaArticuloInsumo(precioArt.getPrecioVentaArticuloInsumo());
                            precioArticuloInsumo.setFechaPrecioArtInsumo(precioArt.getFechaPrecioArtInsumo());
                            precioArticuloInsumo.setCantidadPrecioArtInsumo(precioArt.getCantidadPrecioArtInsumo());

                            precios.add(precioArticuloInsumo);
                        }
                        artInsumo.setPreciosArticulosInsumo(precios);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    //Seteo el RubroArticulo del Insumo
                    try {
                        RubroArticulo rubro = new RubroArticulo();

                        rubro.setIdRubroArticulo(auxDetalle.getArticuloInsumo().getIdArticuloInsumo());
                        rubro.setDenominacionRubroArticulo(auxDetalle.getArticuloInsumo().getRubroArticulo().getDenominacionRubroArticulo());
                        //rubro.setRubroArticuloPadre(articulo2.getRubroArticulo());

                        artInsumo.setRubroArticulo(rubro);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    artMFdetalle.setArticuloInsumo(artInsumo);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                articuloManufacturadoDetalles.add(artMFdetalle);

            }


            int stockMinimo = 1000;
            if (stockMinimo > 0) {
                try {
                    List<PrecioArticuloManufacturado> precios = new ArrayList<>();

                    for (PrecioArticuloManufacturado precioArt : aux.getPrecioArticuloManufacturados()) {

                        PrecioArticuloManufacturado precioArticuloManufacturado = new PrecioArticuloManufacturado();
                        precioArticuloManufacturado.setIdPrecioArticuloManufacturado(precioArt.getIdPrecioArticuloManufacturado());
                        precioArticuloManufacturado.setPrecioCostoArticuloManufacturado(precioArt.getPrecioCostoArticuloManufacturado());
                        precioArticuloManufacturado.setPrecioVentaArticuloManufacturado(precioArt.getPrecioVentaArticuloManufacturado());
                        precioArticuloManufacturado.setFechaPrecioArtManu(precioArt.getFechaPrecioArtManu());
                        precioArticuloManufacturado.setCantidadPrecioArtManu(precioArt.getCantidadPrecioArtManu());

                        precios.add(precioArticuloManufacturado);
                    }
                    aux.setPrecioArticuloManufacturados(precios);

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                aux.setArticuloManufacturadoDetalles(articuloManufacturadoDetalles);


                ArticuloMFRubroDto auxDto2 = ArticuloMFRubroDto.builder().imagenArticuloManu(aux.getImagenArticuloManu()).idArticuloManufacturado(aux.getIdArticuloManufacturado()).denominacionArticuloManu(aux.getDenominacionArticuloManu()).tiempoEstimadoCocina(aux.getTiempoEstimadoCocina()).preciosArticulosManufacturados(aux.getPrecioArticuloManufacturados()).stock(stockMinimo).articuloManufacturadoDetalles(aux.getArticuloManufacturadoDetalles()).rubroGeneral(rubroGeneral).build();
                aux1 = auxDto2;
            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return aux1;
    }

    public ArticuloMFRubroDto guardarArticuloManufacturado(ArticuloMFRubroDto articuloMFRubroDto) {
        ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();


        articuloManufacturado.setTiempoEstimadoCocina(articuloMFRubroDto.getTiempoEstimadoCocina());
        articuloManufacturado.setDenominacionArticuloManu(articuloMFRubroDto.getDenominacionArticuloManu());
        articuloManufacturado.setImagenArticuloManu(articuloMFRubroDto.getImagenArticuloManu());
        articuloManufacturado.setBajaArticuloManu(articuloMFRubroDto.isBajaArticuloManu());

        // articuloManufacturadoDetalles List
        try {
            List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new ArrayList<>();

            for (ArticuloManufacturadoDetalle artMFDet : articuloMFRubroDto.getArticuloManufacturadoDetalles()) {
                ArticuloManufacturadoDetalle artMFDetNuevo = new ArticuloManufacturadoDetalle();


                artMFDetNuevo.setCantidadArticuloManuDetalle(artMFDet.getCantidadArticuloManuDetalle());
                artMFDetNuevo.setUnidadMedidaArticuloManuDetalle(artMFDet.getUnidadMedidaArticuloManuDetalle());
                ArticuloInsumo articuloInsumo = new ArticuloInsumo();
                if (artMFDet.getArticuloInsumo().getIdArticuloInsumo() == 0) {
                    artMFDetNuevo.setArticuloInsumo(null);
                } else {
                    try {
                        articuloInsumo.setIdArticuloInsumo(artMFDet.getArticuloInsumo().getIdArticuloInsumo());
                        articuloInsumo.setDenominacionArticuloInsumo(artMFDet.getArticuloInsumo().getDenominacionArticuloInsumo());
                        articuloInsumo.setImagenArticuloInsumo(artMFDet.getArticuloInsumo().getImagenArticuloInsumo());
                        articuloInsumo.setStockActual(artMFDet.getArticuloInsumo().getStockActual());
                        articuloInsumo.setStockMinimo(artMFDet.getArticuloInsumo().getStockMinimo());
                        articuloInsumo.setUnidadMedidaArticuloInsumo(artMFDet.getArticuloInsumo().getUnidadMedidaArticuloInsumo());
                        articuloInsumo.setEsArticuloInsumo(artMFDet.getArticuloInsumo().isEsArticuloInsumo());
                        articuloInsumo.setBajaArticuloInsumo(artMFDet.getArticuloInsumo().isBajaArticuloInsumo());

                        try {
                            List<PrecioArticuloInsumo> preciosArticulosInsumo = new ArrayList<>();
                            for (PrecioArticuloInsumo precio : artMFDet.getArticuloInsumo().getPreciosArticulosInsumo()) {
                                PrecioArticuloInsumo precioNuevo = new PrecioArticuloInsumo();

                                precioNuevo.setIdPrecio(precio.getIdPrecio());
                                precioNuevo.setPrecioCostoArticuloInsumo(precio.getPrecioCostoArticuloInsumo());
                                precioNuevo.setPrecioVentaArticuloInsumo(precio.getPrecioVentaArticuloInsumo());
                                precioNuevo.setFechaPrecioArtInsumo(precio.getFechaPrecioArtInsumo());
                                precioNuevo.setCantidadPrecioArtInsumo(precio.getCantidadPrecioArtInsumo());

                                preciosArticulosInsumo.add(precioNuevo);
                            }
                            articuloInsumo.setPreciosArticulosInsumo(preciosArticulosInsumo);


                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }
                        try {
                            RubroArticulo rubroArticulo = new RubroArticulo();
                            rubroArticulo.setIdRubroArticulo(artMFDet.getArticuloInsumo().getRubroArticulo().getIdRubroArticulo());
                            //   rubroArticulo.setIdRubroArticulo(1);
                            articuloInsumo.setRubroArticulo(rubroArticulo);


                            //add
                            artMFDetNuevo.setArticuloInsumo(articuloInsumo);
                        } catch (Exception e) {
                            artMFDetNuevo.setArticuloInsumo(null);
                            System.out.println(e.getMessage());
                        }


                    } catch (Exception ex) {                    //catch TRY
                        System.out.println(ex.getMessage());
                    }
                }                   //ELSE
                //add detalle
                articuloManufacturadoDetalles.add(artMFDetNuevo);

            }
            articuloManufacturado.setArticuloManufacturadoDetalles(articuloManufacturadoDetalles);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        // precioArticuloManufacturados List
        try {
            List<PrecioArticuloManufacturado> preciosArticulosManufacturados = new ArrayList<>();
            for (PrecioArticuloManufacturado precio : articuloMFRubroDto.getPreciosArticulosManufacturados()) {
                PrecioArticuloManufacturado precioNuevo = new PrecioArticuloManufacturado();

                precioNuevo.setIdPrecioArticuloManufacturado(precio.getIdPrecioArticuloManufacturado());
                precioNuevo.setPrecioCostoArticuloManufacturado(precio.getPrecioCostoArticuloManufacturado());
                precioNuevo.setPrecioVentaArticuloManufacturado(precio.getPrecioVentaArticuloManufacturado());
                precioNuevo.setFechaPrecioArtManu(precio.getFechaPrecioArtManu());
                precioNuevo.setCantidadPrecioArtManu(precio.getCantidadPrecioArtManu());

                preciosArticulosManufacturados.add(precioNuevo);
            }

            articuloManufacturado.setPrecioArticuloManufacturados(preciosArticulosManufacturados);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // rubroGeneral Obj
        try {
            RubroGeneral rubroGeneral = new RubroGeneral();
            rubroGeneral.setIdRubroGeneral(articuloMFRubroDto.getRubroGeneral().getIdRubroGeneral());

            articuloManufacturado.setRubroGeneral(rubroGeneral);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        articuloManufacturadoRepositorio.save(articuloManufacturado);
        articuloMFRubroDto.setIdArticuloManufacturado(articuloManufacturado.getIdArticuloManufacturado());
        return articuloMFRubroDto;
    }


    public ArticuloMFRubroDto modificarArticuloManufacturado(ArticuloMFRubroDto articuloMFRubroDto, int idArticuloManufacturado) {
        Optional<ArticuloManufacturado> optional = articuloManufacturadoRepositorio.findById(idArticuloManufacturado);
        ArticuloManufacturado articuloManufacturado = new ArticuloManufacturado();

        try {
            articuloManufacturado = optional.get();

            articuloManufacturado.setTiempoEstimadoCocina(articuloMFRubroDto.getTiempoEstimadoCocina());
            articuloManufacturado.setDenominacionArticuloManu(articuloMFRubroDto.getDenominacionArticuloManu());
            articuloManufacturado.setImagenArticuloManu(articuloMFRubroDto.getImagenArticuloManu());
            articuloManufacturado.setBajaArticuloManu(articuloMFRubroDto.isBajaArticuloManu());

            // articuloManufacturadoDetalles List
            try {
                List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles = new ArrayList<>();
                for (ArticuloManufacturadoDetalle artMFDet : articuloMFRubroDto.getArticuloManufacturadoDetalles()) {
                    ArticuloManufacturadoDetalle artMFDetNuevo = new ArticuloManufacturadoDetalle();

                    artMFDetNuevo.setCantidadArticuloManuDetalle(artMFDet.getCantidadArticuloManuDetalle());
                    artMFDetNuevo.setUnidadMedidaArticuloManuDetalle(artMFDet.getUnidadMedidaArticuloManuDetalle());

                    Optional<ArticuloInsumo> optionalInsumo = articuloInsumoRepositorio.findById(artMFDet.getArticuloInsumo().getIdArticuloInsumo());
                    ArticuloInsumo articuloInsumo = new ArticuloInsumo();

                    try {
                        articuloInsumo = optionalInsumo.get();

                        articuloInsumo.setIdArticuloInsumo(artMFDet.getArticuloInsumo().getIdArticuloInsumo());
                        articuloInsumo.setDenominacionArticuloInsumo(artMFDet.getArticuloInsumo().getDenominacionArticuloInsumo());
                        articuloInsumo.setImagenArticuloInsumo(artMFDet.getArticuloInsumo().getImagenArticuloInsumo());
                        articuloInsumo.setStockActual(artMFDet.getArticuloInsumo().getStockActual());
                        articuloInsumo.setStockMinimo(artMFDet.getArticuloInsumo().getStockMinimo());
                        articuloInsumo.setUnidadMedidaArticuloInsumo(artMFDet.getArticuloInsumo().getUnidadMedidaArticuloInsumo());
                        articuloInsumo.setEsArticuloInsumo(artMFDet.getArticuloInsumo().isEsArticuloInsumo());
                        articuloInsumo.setBajaArticuloInsumo(artMFDet.getArticuloInsumo().isBajaArticuloInsumo());

                    /*    try {
                            List<PrecioArticuloInsumo> preciosArticulosInsumo = new ArrayList<>();
                            for (PrecioArticuloInsumo precio : artMFDet.getArticuloInsumo().getPreciosArticulosInsumo()) {
                                PrecioArticuloInsumo precioNuevo = new PrecioArticuloInsumo();

                                precioNuevo.setIdPrecio(precio.getIdPrecio());
                                precioNuevo.setPrecioCostoArticuloInsumo(precio.getPrecioCostoArticuloInsumo());
                                precioNuevo.setPrecioVentaArticuloInsumo(precio.getPrecioVentaArticuloInsumo());
                                precioNuevo.setFechaPrecioArtInsumo(precio.getFechaPrecioArtInsumo());
                                precioNuevo.setCantidadPrecioArtInsumo(precio.getCantidadPrecioArtInsumo());

                                preciosArticulosInsumo.add(precioNuevo);
                            }
                            articuloInsumo.setPreciosArticulosInsumo(preciosArticulosInsumo);


                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }*/
                        try {
                            RubroArticulo rubroArticulo = new RubroArticulo();
                            rubroArticulo.setIdRubroArticulo(artMFDet.getArticuloInsumo().getRubroArticulo().getIdRubroArticulo());
                            //   rubroArticulo.setIdRubroArticulo(1);
                            articuloInsumo.setRubroArticulo(rubroArticulo);


                            //add
                            artMFDetNuevo.setArticuloInsumo(articuloInsumo);
                        } catch (Exception e) {
                            System.out.println(e.getMessage());
                        }

                        //add detalle
                        articuloManufacturadoDetalles.add(artMFDetNuevo);

                    } catch (Exception ex) {                         //catch TRY
                        System.out.println(ex.getMessage());
                    }

                }
                articuloManufacturado.setArticuloManufacturadoDetalles(articuloManufacturadoDetalles);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }


            // precioArticuloManufacturados List
            try {
                List<PrecioArticuloManufacturado> preciosArticulosManufacturados = new ArrayList<>();
                for (PrecioArticuloManufacturado precio : articuloMFRubroDto.getPreciosArticulosManufacturados()) {
                    PrecioArticuloManufacturado precioNuevo = new PrecioArticuloManufacturado();

                    precioNuevo.setIdPrecioArticuloManufacturado(precio.getIdPrecioArticuloManufacturado());
                    precioNuevo.setPrecioCostoArticuloManufacturado(precio.getPrecioCostoArticuloManufacturado());
                    precioNuevo.setPrecioVentaArticuloManufacturado(precio.getPrecioVentaArticuloManufacturado());
                    precioNuevo.setFechaPrecioArtManu(precio.getFechaPrecioArtManu());
                    precioNuevo.setCantidadPrecioArtManu(precio.getCantidadPrecioArtManu());

                    preciosArticulosManufacturados.add(precioNuevo);
                }

                articuloManufacturado.setPrecioArticuloManufacturados(preciosArticulosManufacturados);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            // rubroGeneral Obj
            try {
                RubroGeneral rubroGeneral = new RubroGeneral();
                rubroGeneral.setIdRubroGeneral(articuloMFRubroDto.getRubroGeneral().getIdRubroGeneral());

                articuloManufacturado.setRubroGeneral(rubroGeneral);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            articuloManufacturadoRepositorio.save(articuloManufacturado);
            articuloMFRubroDto.setIdArticuloManufacturado(articuloManufacturado.getIdArticuloManufacturado());

        } catch (Exception e) {
            System.out.println("Bad Request");
            articuloMFRubroDto.setIdArticuloManufacturado(0);
        }

        return articuloMFRubroDto;
    }

}

















