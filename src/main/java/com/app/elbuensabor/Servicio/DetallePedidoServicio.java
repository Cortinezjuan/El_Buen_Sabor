package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.DetallePedido;
import com.app.elbuensabor.Repositorio.DetallePedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetallePedidoServicio {

    @Autowired
    DetallePedidoRepositorio detallePedidoRepositorio;

    public List<DetallePedido> listarDetallePedido() {
        return detallePedidoRepositorio.findAll();
    }

    public Optional<DetallePedido> listarDetallePedidoPorId(int id) {
        return detallePedidoRepositorio.findById(id);
    }

    public DetallePedido guardarDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepositorio.save(detallePedido);
    }

    public DetallePedido modificarDetallePedido(DetallePedido detallePedido) {
        return detallePedidoRepositorio.save(detallePedido);
    }
}
