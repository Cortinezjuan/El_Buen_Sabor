package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Factura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {
}
