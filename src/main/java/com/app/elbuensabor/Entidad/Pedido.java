package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


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
    @OneToOne
    private Factura factura;
    @OneToMany
    private List<DetallePedido> detalles;
    @ManyToOne
    private Usuario usuario;
    @OneToOne
    private Domicilio domicilio;

    public Pedido(int idPedido, int idUsuario, int idFactura, int idDomicilioEntrega, Date fechaPedido, int numeroPedido, int estadoPedido, Date horaEstimadaFinPedido, int tipoEnvio, double totalPedido, Factura factura, List<DetallePedido> detalles, Usuario usuario, Domicilio domicilio) {
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
        this.factura = factura;
        this.detalles = detalles;
        this.usuario = usuario;
        this.domicilio = domicilio;
    }
}
