package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Dto.PedidoDto;
import com.app.elbuensabor.Entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.CriteriaUpdate;
import javax.persistence.metamodel.Metamodel;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface PedidoRepositorio  extends JpaRepository <Pedido, Integer> {
    @Query(value="SELECT * FROM pedido WHERE baja_pedido = false", nativeQuery = true)
    List<Pedido> listarPedidos();

    //Cantidad de pedidos agrupados por cliente en un determinado periodo de tiempo
   @Query(value="SELECT NEW com.app.elbuensabor.Dto.PedidoDto(p.id_pedido, p.usuario_id_usuario,p.cantidad_usuarios) , COUNT(*) FROM pedido p WHERE fecha_pedido" +
            " BETWEEN :fecha1 AND :fecha2 AND baja_pedido=false GROUP BY usuario_id_usuario", nativeQuery=true)
    List<PedidoDto> buscarPedidosAgrupadosPorId(Date fecha1, Date fecha2);

    //Ranking comidas más pedidas en un periodo de tiempo determinado:
    //consulta SQL
    //SELECT * FROM pedido WHERE fechaPedido BETWEEN fecha1 AND fecha2
    //método del repositorio
    @Query(value="SELECT * FROM pedido WHERE fecha_pedido BETWEEN :fecha1 AND :fecha2", nativeQuery=true)
    List<Pedido> buscarPedidosPorFechas(Date fecha1, Date fecha2);


}
