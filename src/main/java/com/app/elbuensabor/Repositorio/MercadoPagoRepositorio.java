package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.MercadoPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MercadoPagoRepositorio extends JpaRepository<MercadoPago, Integer> {
}
