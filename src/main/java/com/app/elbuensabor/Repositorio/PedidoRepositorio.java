package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Dto.PedidosPorUsuariosDto;
import com.app.elbuensabor.Dto.RankingComidasDto;
import com.app.elbuensabor.Entidad.Pedido;
import com.app.elbuensabor.Entidad.Usuario;
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
   @Query(value="SELECT p.`id_usuario`,u.`nombres`,u.`apellidos` , " +
           "COUNT(*) AS cantidad_pedidos FROM pedido p " +
           "INNER JOIN usuario u WHERE fecha_pedido BETWEEN " +
           ":fecha1 AND :fecha2 AND p.`baja_pedido`=FALSE AND " +
           "p.`id_usuario` = u.`id_usuario` GROUP BY id_usuario " +
           "ORDER BY cantidad_pedidos DESC", nativeQuery=true)
    List<String> buscarPedidosAgrupadosPorId(Date fecha1, Date fecha2);


    //Ranking comidas más pedidas en un periodo de tiempo determinado:
    @Query(value="SELECT am.`denominacion_articulo_manu`, " +
            "COUNT(*) AS rankingComidas FROM pedido p INNER JOIN " +
            "detalle_pedido dp INNER JOIN articulo_manufacturado am " +
            "WHERE p.fecha_pedido BETWEEN :fecha1 AND :fecha2 AND" +
            " p.baja_pedido=FALSE AND dp.`id_pedido` = p.`id_pedido` AND" +
            " am.`id_articulo_manufacturado` = dp.`id_articulo_manufacturado` " +
            "GROUP BY dp.`id_articulo_manufacturado` ORDER BY rankingComidas DESC  ", nativeQuery=true)
    List<String> rankingComidasPorFechas(Date fecha1, Date fecha2);

    @Query(value="SELECT MAX(id_pedido) from pedido", nativeQuery = true)
    int findIdUltimoPedido();

    @Query(value="SELECT * from pedido WHERE id_usuario=:idUsuario", nativeQuery = true)
    List<Pedido> findByidUsuario(int idUsuario);

}
