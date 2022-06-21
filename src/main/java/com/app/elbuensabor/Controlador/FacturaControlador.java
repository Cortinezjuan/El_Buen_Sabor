package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class FacturaControlador {
    @Autowired
    FacturaServicio facturaServicio;

    @GetMapping("/listarFacturas")
    public List<Factura> listarFacturas() {
        return facturaServicio.listarFacturas();
    }

    @GetMapping("/listarFacturaXId/{id}")
    public Optional<Factura> listarFacturaPorId(@PathVariable("id") int id) {
        return facturaServicio.listarFacturaPorId(id);
    }

    @GetMapping("/ingresosPorPeriodo")
    public Double ingresosPorPeriodo(@RequestParam(name= "fecha1", defaultValue = "null", required = false) String fecha1, @RequestParam(name="fecha2",defaultValue = "null", required = false) String fecha2) throws ParseException {
        Date fecha3 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
        Date fecha4 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha2);
        return facturaServicio.ingresosPorPeriodo(fecha3, fecha4);
    }

    @GetMapping("/gananciaPorPeriodo")
    public Double gananciasPorPeriodo(@RequestParam(name= "fecha1", defaultValue = "null", required = false) String fecha1, @RequestParam(name="fecha2",defaultValue = "null", required = false) String fecha2) throws ParseException {
        Date fecha3 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha1);
        Date fecha4 = new SimpleDateFormat("yyyy-MM-dd").parse(fecha2);
        return facturaServicio.gananciaPorPeriodo(fecha3, fecha4);
    }




    @PostMapping("/crearFactura")
    public Factura crearFactura(@RequestBody Factura factura) {
        return facturaServicio.guardarFactura(factura);
    }

    @DeleteMapping("/borrarFactura/{id}")
    public void borrarFactura(@PathVariable("id") int id) {
        facturaServicio.borrarFactura(id);
    }

    @PutMapping("/modificarFactura")
    public Factura modificarFactura(@RequestBody Factura factura) {
        return facturaServicio.modificarFactura(factura);
    }
}
