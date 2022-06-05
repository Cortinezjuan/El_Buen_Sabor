package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloInsumoRepositorio extends JpaRepository <ArticuloInsumo, Integer> {
    @Query(value="SELECT * FROM articulo_insumo WHERE baja_articulo_insumo = false", nativeQuery = true)
    List<ArticuloInsumo> listarArticulosInsumo();
}
