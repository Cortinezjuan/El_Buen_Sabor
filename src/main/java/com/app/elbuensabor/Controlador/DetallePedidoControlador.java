package com.app.elbuensabor.Controlador;


import com.app.elbuensabor.Entidad.DetallePedido;
import com.app.elbuensabor.Servicio.DetallePedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DetallePedidoControlador {
    @Autowired
    DetallePedidoServicio detallePedidoServicio;

    @GetMapping("/listarDetallePedidos")
    public List<DetallePedido> listarPedidos(){
        return detallePedidoServicio.listarDetallePedido();
    }

    @GetMapping("/listarDetallePedidoXId/{id}")
    public Optional<DetallePedido> listarDetallePedidoPorId(@PathVariable("id") int id){
        return detallePedidoServicio.listarDetallePedidoPorId(id);
    }

    @PostMapping("/crearDetallePedido")
    public DetallePedido crearDetallePedido(@RequestBody DetallePedido detallePedido){
        return detallePedidoServicio.guardarDetallePedido(detallePedido);
    }

    @PutMapping("/modificarDetallePedido")
    public DetallePedido modificarDetallePedido(@RequestBody DetallePedido detallePedido){
        return detallePedidoServicio.modificarDetallePedido(detallePedido);
    }
}
