package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.ArticuloInsumoDto;
import com.app.elbuensabor.Dto.BebidaDto;
import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Entidad.PrecioArticuloInsumo;
import com.app.elbuensabor.Entidad.RubroArticulo;
import com.app.elbuensabor.Repositorio.ArticuloInsumoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ExecutionException;

@Service
public class ArticuloInsumoServicio {

    @Autowired
    ArticuloInsumoRepositorio articuloInsumoRepositorio;

    public List<BebidaDto> listarBebidas() {
        List<ArticuloInsumo> articulos = articuloInsumoRepositorio.listarBebidas();
        List<BebidaDto> bebidas = new ArrayList<>();
        for (ArticuloInsumo aux : articulos) {
            BebidaDto bebida = BebidaDto.builder()
                    .idBebida(aux.getIdArticuloInsumo())
                    .nombreBebida(aux.getDenominacionArticuloInsumo())
                    .imagenBebida(aux.getImagenArticuloInsumo())
                    .stock(aux.getStockActual())
                    .precioTotal(aux.getPreciosArticulosInsumo().get(0).getPrecioVentaArticuloInsumo())
                    .build();
            bebidas.add(bebida);
        }
        return bebidas;
    }

    public List<ArticuloInsumoDto> listarArticulosInsumo() {
        List<ArticuloInsumoDto> result = new ArrayList<>();

        for ( ArticuloInsumo articulo2 : articuloInsumoRepositorio.findAll() ) {
            ArticuloInsumoDto articulo = new ArticuloInsumoDto();

            articulo.setIdArticuloInsumo(articulo2.getIdArticuloInsumo());
            articulo.setDenominacionArticuloInsumo(articulo2.getDenominacionArticuloInsumo());
            articulo.setImagenArticuloInsumo(articulo2.getImagenArticuloInsumo());
            articulo.setStockActual(articulo2.getStockActual());
            articulo.setStockMinimo(articulo2.getStockMinimo());
            articulo.setUnidadMedidaArticuloInsumo(articulo2.getUnidadMedidaArticuloInsumo());
            articulo.setEsArticuloInsumo(articulo2.isEsArticuloInsumo());

            try {
                List<PrecioArticuloInsumo> precio = new ArrayList<>();

                for (PrecioArticuloInsumo precioArt : articulo2.getPreciosArticulosInsumo() ) {
                    PrecioArticuloInsumo precioArticuloInsumo = new PrecioArticuloInsumo();
                    precioArticuloInsumo.setIdPrecio(precioArt.getIdPrecio());
                    precioArticuloInsumo.setPrecioCostoArticuloInsumo(precioArt.getPrecioCostoArticuloInsumo());
                    precioArticuloInsumo.setPrecioVentaArticuloInsumo(precioArt.getPrecioVentaArticuloInsumo());
                    precioArticuloInsumo.setFechaPrecioArtInsumo(precioArt.getFechaPrecioArtInsumo());
                    precioArticuloInsumo.setCantidadPrecioArtInsumo(precioArt.getCantidadPrecioArtInsumo());

                    precio.add(precioArticuloInsumo);
                }
                articulo.setPreciosArticulosInsumo(precio);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            //Seteo el RubroArticulo del Insumo
            try {
                RubroArticulo rubro = new RubroArticulo();

                rubro.setIdRubroArticulo(articulo2.getIdArticuloInsumo());
                rubro.setDenominacionRubroArticulo(articulo2.getRubroArticulo().getDenominacionRubroArticulo());
                //rubro.setRubroArticuloPadre(articulo2.getRubroArticulo());

                articulo.setRubroArticulo(rubro);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            result.add(articulo);
        }
        return result;
    }

    public Optional<ArticuloInsumo> listarArticuloInsumoPorId(int id) {
        return articuloInsumoRepositorio.findById(id);
    }

    @Transactional
    public ArticuloInsumoDto guardarArticuloInsumo(ArticuloInsumoDto articuloInsumoDto) {
        ArticuloInsumo articuloInsumo = new ArticuloInsumo();

        articuloInsumo.setDenominacionArticuloInsumo(articuloInsumoDto.getDenominacionArticuloInsumo());
        articuloInsumo.setImagenArticuloInsumo(articuloInsumoDto.getImagenArticuloInsumo());
        articuloInsumo.setStockActual(articuloInsumoDto.getStockActual());
        articuloInsumo.setStockMinimo(articuloInsumoDto.getStockMinimo());
        articuloInsumo.setUnidadMedidaArticuloInsumo(articuloInsumoDto.getUnidadMedidaArticuloInsumo());
        articuloInsumo.setEsArticuloInsumo(articuloInsumoDto.isEsArticuloInsumo());
        articuloInsumo.setBajaArticuloInsumo(articuloInsumo.isBajaArticuloInsumo());

        try {
            List<PrecioArticuloInsumo> preciosArticulosInsumo = new ArrayList<>();
            for (PrecioArticuloInsumo precio : articuloInsumoDto.getPreciosArticulosInsumo()) {
                PrecioArticuloInsumo precioNuevo = new PrecioArticuloInsumo();

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
            rubroArticulo.setIdRubroArticulo(articuloInsumoDto.getRubroArticulo().getIdRubroArticulo());
            articuloInsumo.setRubroArticulo(rubroArticulo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        articuloInsumoRepositorio.save(articuloInsumo);
        articuloInsumoDto.setIdArticuloInsumo(articuloInsumo.getIdArticuloInsumo());
        return articuloInsumoDto;
    }

    @Transactional
    public ArticuloInsumoDto modificarArticuloInsumo(ArticuloInsumoDto articuloInsumoDto, int idArticuloInsumo) {
        Optional<ArticuloInsumo> optional = articuloInsumoRepositorio.findById(idArticuloInsumo);
        ArticuloInsumo articuloInsumo = new ArticuloInsumo();

        try {
            articuloInsumo = optional.get();

            articuloInsumo.setDenominacionArticuloInsumo(articuloInsumoDto.getDenominacionArticuloInsumo());
            articuloInsumo.setImagenArticuloInsumo(articuloInsumoDto.getImagenArticuloInsumo());
            articuloInsumo.setStockActual(articuloInsumoDto.getStockActual());
            articuloInsumo.setStockMinimo(articuloInsumoDto.getStockMinimo());
            articuloInsumo.setUnidadMedidaArticuloInsumo(articuloInsumoDto.getUnidadMedidaArticuloInsumo());
            articuloInsumo.setEsArticuloInsumo(articuloInsumoDto.isEsArticuloInsumo());
            articuloInsumo.setBajaArticuloInsumo(articuloInsumo.isBajaArticuloInsumo());

        try {
            List<PrecioArticuloInsumo> preciosArticulosInsumo = new ArrayList<>();
            for (PrecioArticuloInsumo precio : articuloInsumoDto.getPreciosArticulosInsumo()) {
                PrecioArticuloInsumo precioNuevo = new PrecioArticuloInsumo();

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
            rubroArticulo.setIdRubroArticulo(articuloInsumoDto.getRubroArticulo().getIdRubroArticulo());
            articuloInsumo.setRubroArticulo(rubroArticulo);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        articuloInsumoRepositorio.save(articuloInsumo);
        articuloInsumoDto.setIdArticuloInsumo(articuloInsumo.getIdArticuloInsumo());

    }catch(Exception e){
        System.out.println("Bad Request");
        articuloInsumoDto.setIdArticuloInsumo(0);
    }
        return articuloInsumoDto;
    }
    public void borrarArticuloInsumo(int id){
        Optional<ArticuloInsumo> articuloInsumo = articuloInsumoRepositorio.findById(id);
        articuloInsumo.get().setBajaArticuloInsumo(true);
        articuloInsumoRepositorio.save(articuloInsumo.get());
    }
}
