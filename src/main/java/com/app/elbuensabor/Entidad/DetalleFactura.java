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

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idPago", referencedColumnName = "idPago")
    private Pago pago;

    private int cantidadDetalleFactura;
}
