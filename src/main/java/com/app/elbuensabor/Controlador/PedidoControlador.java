package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Pedido;
import com.app.elbuensabor.Servicio.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PedidoControlador {

    @Autowired
    PedidoServicio pedidoServicio;

    @GetMapping("/listarPedidos")
    public List<Pedido> listarPedidos() {
        return pedidoServicio.listarPedidos();
    }

    @GetMapping("/listarPedidoXId/{id}")
    public Optional<Pedido> listarPedidoPorId(@PathVariable("id") int id) {
        return pedidoServicio.listarPedidoPorId(id);
    }

    @PostMapping("/crearPedido")
    public Pedido crearPedido(@RequestBody Pedido pedido) {
        return pedidoServicio.guardarPedido(pedido);
    }

    @DeleteMapping("/borrarPedido/{id}")
    public void borrarPedido(@PathVariable("id") int id) {
        pedidoServicio.borrarPedido(id);
    }

    @PutMapping("/modificarPedido")
    public Pedido modificarPedido(@RequestBody Pedido pedido) {
        return pedidoServicio.modificarPedido(pedido);
    }
}
