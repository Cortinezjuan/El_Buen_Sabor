package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;


@Getter
@Setter
@NoArgsConstructor
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;
    private int idUsuario;
    private int idFactura;
    private int idDomicilioEntrega;
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    private int numeroPedido;
    private int estadoPedido;
    @Temporal(TemporalType.DATE)
    private Date horaEstimadaFinPedido;
    private int tipoEnvio;
    private double totalPedido;
    private boolean bajaPedido;

    //RELACIONES

    public Pedido(int idPedido, int idUsuario, int idFactura, int idDomicilioEntrega, Date fechaPedido, int numeroPedido, int estadoPedido, Date horaEstimadaFinPedido, int tipoEnvio, double totalPedido, boolean bajaPedido) {
        this.idPedido = idPedido;
        this.idUsuario = idUsuario;
        this.idFactura = idFactura;
        this.idDomicilioEntrega = idDomicilioEntrega;
        this.fechaPedido = fechaPedido;
        this.numeroPedido = numeroPedido;
        this.estadoPedido = estadoPedido;
        this.horaEstimadaFinPedido = horaEstimadaFinPedido;
        this.tipoEnvio = tipoEnvio;
        this.totalPedido = totalPedido;
        this.bajaPedido = false;
    }
}
