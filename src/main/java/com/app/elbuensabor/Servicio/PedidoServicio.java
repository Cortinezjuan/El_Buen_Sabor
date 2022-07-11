package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.PedidosPorUsuariosDto;
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

//    public List<PedidosPorUsuariosDto> pedidosPorUsuario(Date fecha1, Date fecha2) {
//        List<PedidosPorUsuariosDto> dtos =pedidoRepositorio.buscarPedidosAgrupadosPorId(fecha1,fecha2).stream().map(entity-> pedidoMapper.pedidoToPedidoPorUsuarioDto(entity)).collect(Collectors.toList());
//        return dtos;
//
//    }

    public List<String>buscarPedidosPorFechas(Date fecha1, Date fecha2){
        List<Pedido> pedidosDB = pedidoRepositorio.buscarPedidosPorFechas(fecha1,fecha2);
        List<String> comidas = new ArrayList<>();
        for(Pedido aux: pedidosDB){
            for(DetallePedido comidasRanking: aux.getDetalles()){
                comidas.add(comidasRanking.getArticuloManufacturado().getDenominacionArticuloManu());
            }
        }
        Collections.sort(comidas);

        return comidas;
    }
}
