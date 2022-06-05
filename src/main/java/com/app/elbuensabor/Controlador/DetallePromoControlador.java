package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.DetallePromo;
import com.app.elbuensabor.Servicio.DetallePromoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class DetallePromoControlador {

    @Autowired
    DetallePromoServicio detallePromoServicio;

    @GetMapping("/listarDetallesPromos")
    public List<DetallePromo> listarDetallesPromos() {
        return detallePromoServicio.listarDetallesPromo();
    }

    @GetMapping("/listarDetallePromoXId/{id}")
    public Optional<DetallePromo> listarDetallePromoPorId(@PathVariable("id") int id) {
        return detallePromoServicio.listarDetallePromoPorId(id);
    }

    @PostMapping("/crearDetallesPromo")
    public DetallePromo crearDetallesPromo(@RequestBody DetallePromo detallePromo) {
        return detallePromoServicio.guardarDetallesPromo(detallePromo);
    }

    @PutMapping("/modificarDetallePromo")
    public DetallePromo modificarDetallePromo(@RequestBody DetallePromo detallePromo) {
        return detallePromoServicio.modificarDetallesPromo(detallePromo);
    }
}
