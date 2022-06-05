package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Entidad.RubroArticulo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroArticuloRepositorio extends JpaRepository <RubroArticulo, Integer> {

    @Query(value="SELECT * FROM rubro_articulo WHERE baja_rubro_articulo = false", nativeQuery = true)
    List<RubroArticulo> listarRubrosArticulos();
}
