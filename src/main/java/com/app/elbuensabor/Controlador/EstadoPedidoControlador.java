package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Estado;
import com.app.elbuensabor.Entidad.EstadoPedido;
import com.app.elbuensabor.Servicio.EstadoPedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins="*", allowedHeaders = "*")
@RestController
public class EstadoPedidoControlador {
    @Autowired
    EstadoPedidoServicio estadoPedidoServicio;

    @GetMapping("/listarEstadoPedidos")
    public List<EstadoPedido> listarEstadoPedidos(){
        return estadoPedidoServicio.listarEstadoPedidos();
    }

    @GetMapping("/listarEstadoPedidoXId/{id}")
    public Optional<EstadoPedido> listarEstadoPedidoPorId(@PathVariable("id") int id){
        return estadoPedidoServicio.listarEstadoPedidoPorId(id);
    }

    @PostMapping("/crearEstadoPedido")
    public EstadoPedido crearEstadoPedido(@RequestBody EstadoPedido estadoPedido){
        return estadoPedidoServicio.guardarEstadoPedido(estadoPedido);
    }

    @PutMapping("/modificarEstadoPedido")
    public EstadoPedido modificarEstadoPedido(@RequestBody EstadoPedido estadoPedido){
        return estadoPedidoServicio.modificarEstadoPedido(estadoPedido);
    }
}
