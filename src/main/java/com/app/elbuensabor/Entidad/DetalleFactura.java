package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class DetalleFactura {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idDetalleFactura;
    @OneToOne
    private Factura factura;
    private int idPago;
    private int cantidadDetalleFactura;
}
