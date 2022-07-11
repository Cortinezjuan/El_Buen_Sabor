package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Dto.PedidosPorUsuariosDto;
import com.app.elbuensabor.Entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


@Repository
public interface PedidoRepositorio  extends JpaRepository <Pedido, Integer> {
    @Query(value="SELECT * FROM pedido WHERE baja_pedido = false", nativeQuery = true)
    List<Pedido> listarPedidos();

    //Cantidad de pedidos agrupados por cliente en un determinado periodo de tiempo
   @Query(value="SELECT * , COUNT(*) AS cantidad_pedidos FROM pedido WHERE fecha_pedido" +
            " BETWEEN :fecha1 AND :fecha2 GROUP BY id_usuario", nativeQuery=true)
    List<Pedido> buscarPedidosAgrupadosPorId(Date fecha1, Date fecha2);

    //Ranking comidas más pedidas en un periodo de tiempo determinado:
    @Query(value="SELECT * FROM pedido WHERE fecha_pedido BETWEEN :fecha1 AND :fecha2 AND baja_pedido=false", nativeQuery=true)
    List<Pedido> buscarPedidosPorFechas(Date fecha1, Date fecha2);


}
