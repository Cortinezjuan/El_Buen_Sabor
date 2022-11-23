package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.FacturaDto;
import com.app.elbuensabor.Dto.PedidoRespDto;
import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Entidad.Pedido;
import com.app.elbuensabor.Repositorio.FacturaRepositorio;
import com.app.elbuensabor.Repositorio.PedidoRepositorio;
import com.app.elbuensabor.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FacturaServicio {
    @Autowired
    FacturaRepositorio facturaRepositorio;
    @Autowired
    PedidoRepositorio pedidoRepositorio;

    public List<Factura> listarFacturas(){
        return facturaRepositorio.listarFacturas();
    }

    public FacturaDto listarFacturaPorId(int id){
        Optional<Factura> facturaBD = facturaRepositorio.findById(id);
        FacturaDto facturaDto = FacturaDto.builder()
                .idFactura(facturaBD.get().getIdFactura())
                .fechaFactura(facturaBD.get().getFechaFactura().toString())
                .numeroFactura(facturaBD.get().getNumeroFactura())
                .porcentajeDescuento(facturaBD.get().getPorcentajeDescuento())
                .totalVenta(facturaBD.get().getTotalVenta())
                .totalCosto(facturaBD.get().getTotalCosto())
                .build();
        return facturaDto;
    }

    public Factura guardarFactura(Factura factura){
        return facturaRepositorio.save(factura);
    }

    public void borrarFactura(int id){
        Optional<Factura> factura = facturaRepositorio.findById(id);
        factura.get().setBajaFactura(true);
        facturaRepositorio.save(factura.get());
    }

    public Factura modificarFactura(Factura factura){
        return facturaRepositorio.save(factura);
    }

    public Double ingresosPorPeriodo(Date fecha1, Date fecha2) {
           return facturaRepositorio.ingresosPorPeriodo(fecha1, fecha2);
    }

    public Double gananciaPorPeriodo(Date fecha1, Date fecha2) {
        return facturaRepositorio.gananciaPorPeriodo(fecha1, fecha2);
    }

    public Factura getFacturaByIdPedido(int idPedido){
        Optional<Pedido> pedido = pedidoRepositorio.findById(idPedido);
        Factura factura = pedido.get().getFactura();
        return factura;
    }
}
