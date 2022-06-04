package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.EstadoPedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoPedidoRepositorio extends JpaRepository<EstadoPedido, Integer> {
}
