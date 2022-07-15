package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.PedidosPorUsuariosDto;
import com.app.elbuensabor.Dto.RankingComidasDto;
import com.app.elbuensabor.Entidad.DetallePedido;
import com.app.elbuensabor.Entidad.Pedido;
import com.app.elbuensabor.Repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PedidoServicio {

    @Autowired
    PedidoRepositorio pedidoRepositorio;

    public List<Pedido> listarPedidos() {
        return pedidoRepositorio.listarPedidos();
    }

    public Optional<Pedido> listarPedidoPorId(int id) {
        return pedidoRepositorio.findById(id);
    }

    public Pedido guardarPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    public void borrarPedido(int id) {
        Optional<Pedido> pedido = pedidoRepositorio.findById(id);
        pedido.get().setBajaPedido(true);
        pedidoRepositorio.save(pedido.get());
    }

    public Pedido modificarPedido(Pedido pedido) {
        return pedidoRepositorio.save(pedido);
    }

    public List<PedidosPorUsuariosDto> pedidosPorUsuario(Date fecha1, Date fecha2) {
        List<String> pedidosDB = pedidoRepositorio.buscarPedidosAgrupadosPorId(fecha1,fecha2);
        List<PedidosPorUsuariosDto> pedidos = new ArrayList<>();
        for(String aux: pedidosDB){
            String[] textElement = aux.split(",");
            PedidosPorUsuariosDto pedidoDto = PedidosPorUsuariosDto.builder()
                    .id_usuario(Integer.parseInt(textElement[0]))
                    .nombreUsuario(textElement[1])
                    .apellidoUsuario(textElement[2])
                    .cantidadPedidos(Integer.parseInt(textElement[3]))
                    .build();
            pedidos.add(pedidoDto);
        }
        return pedidos;
    }

    public List<RankingComidasDto>rankingComidasPorFechas(Date fecha1, Date fecha2){
        List<String> pedidosDB = pedidoRepositorio.rankingComidasPorFechas(fecha1,fecha2);
        List<RankingComidasDto> comidas = new ArrayList<>();
        for(String aux: pedidosDB){
            String[] textElement = aux.split(",");
            RankingComidasDto comidaDto = RankingComidasDto.builder()
                    .nombreComida(textElement[0])
                    .cantPedida(Integer.parseInt(textElement[1]))
                    .build();
            comidas.add(comidaDto);
        }

        return comidas;
    }
}
