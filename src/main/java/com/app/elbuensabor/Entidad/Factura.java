package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
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

    /*@OneToOne()
    @JoinColumn(name="idDetalleFactura", referencedColumnName = "idDetalleFactura")
    private DetalleFactura detalleFactura;*/

    public Factura(int idFactura, DetalleFactura detalleFactura, Date fechaFactura, int numeroFactura, double porcentajeDescuento, double totalVenta, double totalCosto) {

        //this.detalleFactura = detalleFactura;
        this.fechaFactura = fechaFactura;
        this.numeroFactura = idFactura;
        this.porcentajeDescuento = porcentajeDescuento;
        this.totalVenta = totalVenta;
        this.totalCosto = totalCosto;
        this.bajaFactura = false;
    }
}
