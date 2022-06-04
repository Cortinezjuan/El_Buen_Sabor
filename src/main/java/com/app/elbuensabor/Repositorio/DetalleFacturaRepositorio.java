package com.app.elbuensabor.Repositorio;


import com.app.elbuensabor.Entidad.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleFacturaRepositorio extends JpaRepository<DetalleFactura, Integer> {

}
