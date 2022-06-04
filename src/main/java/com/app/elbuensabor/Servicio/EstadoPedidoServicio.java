package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Estado;
import com.app.elbuensabor.Entidad.EstadoPedido;
import com.app.elbuensabor.Repositorio.EstadoPedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstadoPedidoServicio {
    @Autowired
    EstadoPedidoRepositorio estadoPedidoRepositorio;

    public List<EstadoPedido> listarEstadoPedidos(){
        return estadoPedidoRepositorio.findAll();
    }

    public Optional<EstadoPedido> listarEstadoPedidoPorId(int id){
        return estadoPedidoRepositorio.findById(id);
    }

    public EstadoPedido guardarEstadoPedido(EstadoPedido estadoPedido){
        return estadoPedidoRepositorio.save(estadoPedido);
    }

    public EstadoPedido modificarEstadoPedido(EstadoPedido estadoPedido){
        return estadoPedidoRepositorio.save(estadoPedido);
    }
}
