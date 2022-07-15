package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Dto.PedidosPorUsuariosDto;
import com.app.elbuensabor.Dto.RankingComidasDto;
import com.app.elbuensabor.Entidad.Pedido;
import com.app.elbuensabor.Servicio.PedidoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/pedido")
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

    @GetMapping("/pedidosPorUsuario")
    public List<PedidosPorUsuariosDto> pedidosPorPeriodo(@RequestParam(name= "fecha1", defaultValue = "null", required = false) String fecha1, @RequestParam(name="fecha2",defaultValue = "null", required = false) String fecha2) throws ParseException {
        Date fecha3 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
        Date fecha4 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha2);
        return pedidoServicio.pedidosPorUsuario(fecha3, fecha4);
    }

    @GetMapping("/pedidosPorFechas")
    public List<RankingComidasDto> pedidosPorFechas(@RequestParam(name= "fecha1", defaultValue = "null", required = false) String fecha1, @RequestParam(name="fecha2",defaultValue = "null", required = false) String fecha2) throws ParseException {
        Date fecha3 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
        Date fecha4 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha2);
        return pedidoServicio.rankingComidasPorFechas(fecha3, fecha4);
    }


}
