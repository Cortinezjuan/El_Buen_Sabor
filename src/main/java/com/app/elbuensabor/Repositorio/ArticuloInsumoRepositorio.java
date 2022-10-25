package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Dto.ArticuloInsumoDto;
import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepositorio extends JpaRepository <ArticuloInsumo, Integer> {
    @Query(value="SELECT * FROM articulo_insumo WHERE baja_articulo_insumo = false", nativeQuery = true)
    List<ArticuloInsumo> listarAritculosInsumo();

    @Query(value="SELECT stock_actual " +
            "FROM articulo_insumo " +
            "WHERE id_articulo_insumo = :idArticulo ", nativeQuery = true)
    double findStockByIdArticuloInsumo(int idArticulo);

    @Query(value="SELECT * FROM articulo_insumo WHERE baja_articulo_insumo = false AND es_articulo_insumo= false", nativeQuery = true)
    List<ArticuloInsumo> listarBebidas();
}
