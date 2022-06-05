package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PedidoRepositorio  extends JpaRepository <Pedido, Integer> {
    @Query(value="SELECT * FROM pedido WHERE baja_pedido = false", nativeQuery = true)
    List<Pedido> listarPedidos();
}
