package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Factura {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idFactura;
    private Date fechaFactura;
    private int numeroFactura;
    private double porcentajeDescuento;
    private double totalVenta;
    private double totalCosto;
}
