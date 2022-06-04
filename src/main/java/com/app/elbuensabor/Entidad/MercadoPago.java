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
public class MercadoPago {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idMercadoPago;
    @OneToOne
    private Pago pago;
    private String identificadorPago;
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;
    private String formaPago;
    private String metodoPago;
    private String nroTarjeta;
    private String EstadoMercadoPago;
}
