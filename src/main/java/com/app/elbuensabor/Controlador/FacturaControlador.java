package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Dto.PedidoRespDto;
import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Servicio.EnvioMail;
import com.app.elbuensabor.Servicio.FacturaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/factura")
public class FacturaControlador {
    @Autowired
    FacturaServicio facturaServicio;
    @Autowired
    EnvioMail envioMail;

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

    @GetMapping("/sendMail")
    public void envioMail(@RequestParam(name="mail",required = false)String mail,@RequestParam(name="subject",required = false)String subject,@RequestParam(name="content",required = false)String content ){
        envioMail.sendEmail(mail,subject,content);
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

    @GetMapping("/facturasPorIdPedido")
    public Factura getFacturaByIdPedido(@RequestParam(name="idPedido",required = false)int idPedido ){
        return facturaServicio.getFacturaByIdPedido(idPedido);
    }
}
