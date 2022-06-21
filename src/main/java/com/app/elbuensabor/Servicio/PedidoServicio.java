package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.PedidoDto;
import com.app.elbuensabor.Entidad.Pedido;
import com.app.elbuensabor.Repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    public List<PedidoDto> pedidosPorUsuario(Date fecha1, Date fecha2) {
          return pedidoRepositorio.buscarPedidosAgrupadosPorId(fecha1, fecha2);
    }

    public List<Pedido>buscarPedidosPorFechas(Date fecha1, Date fecha2){
        return pedidoRepositorio.buscarPedidosPorFechas(fecha1,fecha2);
    }
}
