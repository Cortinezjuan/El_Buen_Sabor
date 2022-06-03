package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idFactura;
    @Temporal(TemporalType.DATE)
    private Date fechaFactura;
    private int numeroFactura;
    private double porcentajeDescuento;
    private double totalVenta;
    private double totalCosto;
    private boolean bajaFactura;

    public Factura(int idFactura, Date fechaFactura, int numeroFactura, double porcentajeDescuento, double totalVenta, double totalCosto) {
        this.idFactura = idFactura;
        this.fechaFactura = fechaFactura;
        this.numeroFactura = numeroFactura;
        this.porcentajeDescuento = porcentajeDescuento;
        this.totalVenta = totalVenta;
        this.totalCosto = totalCosto;
        this.bajaFactura = false;
    }
}
