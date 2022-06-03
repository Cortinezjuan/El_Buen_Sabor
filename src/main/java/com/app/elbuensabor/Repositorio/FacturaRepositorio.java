package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {

    @Query(value="SELECT * FROM factura WHERE baja_factura = false", nativeQuery = true)
    List<Factura> listarFacturas();
}
