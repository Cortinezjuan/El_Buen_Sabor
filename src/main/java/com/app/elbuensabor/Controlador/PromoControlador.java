package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Promo;
import com.app.elbuensabor.Servicio.PromoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class PromoControlador {

    @Autowired
    PromoServicio promoServicio;

    @GetMapping("/listarPromos")
    public List<Promo> listarPromos() {
        return promoServicio.listarPromos();
    }

    @GetMapping("/listarPromoXId/{id}")
    public Optional<Promo> listarPromoPorId(@PathVariable("id") int id) {
        return promoServicio.listarPromoPorId(id);
    }

    @PostMapping("/crearPromo")
    public Promo crearPromo(@RequestBody Promo promo) {
        return promoServicio.guardarPromo(promo);
    }

    @DeleteMapping("/borrarPromo/{id}")
    public void borrarPromo(@PathVariable("id") int id) {
        promoServicio.borrarPromo(id);
    }

    @PutMapping("/modificarPromo")
    public Promo modificarPromo(@RequestBody Promo promo) {
        return promoServicio.modificarPromo(promo);
    }
}
