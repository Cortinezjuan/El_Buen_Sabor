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
public class Pago {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idPago;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idMercadoPago", referencedColumnName = "idMercadoPago")
    private MercadoPago mercadoPago;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idEfectivo", referencedColumnName = "idEfectivo")
    private Efectivo efectivo;
}
