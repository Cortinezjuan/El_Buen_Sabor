package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Pago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepositorio extends JpaRepository<Pago, Integer> {
}
