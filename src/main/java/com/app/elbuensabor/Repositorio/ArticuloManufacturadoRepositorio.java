package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.ArticuloManufacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticuloManufacturadoRepositorio extends JpaRepository<ArticuloManufacturado, Integer> {

    @Query(value="SELECT * FROM articulo_manufacturado WHERE baja_articulo_manufacturado = false", nativeQuery = true)
    List<ArticuloManufacturado> listarArticuloManufacturados();
}
