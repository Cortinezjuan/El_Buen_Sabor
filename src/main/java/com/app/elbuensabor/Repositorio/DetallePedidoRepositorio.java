package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.DetallePedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePedidoRepositorio extends JpaRepository<DetallePedido, Integer> {
}
