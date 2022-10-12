package com.app.elbuensabor.Entidad;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Formatter;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor

@Entity
@Builder
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPedido;

    private Date fechaPedido;
    private int numeroPedido;
    private Date horaEstimadaFinPedido;
    private int tipoEnvio;
    private double totalPedido;
    @Column(name="baja_pedido")
    private boolean bajaPedido;

    //RELACIONES
    @OneToOne
    private Factura factura;
    @OneToMany(mappedBy="pedido", cascade=CascadeType.ALL)
    private List<DetallePedido> detalles;
    @ManyToOne
    @JoinColumn(name="idUsuario")
    private Usuario usuario;
    @OneToOne
    @JoinColumn(name="idDomicilio")
    private Domicilio domicilio;
    @OneToOne
    private Estado estado;

    public Pedido(int idPedido, Date fechaPedido, int numeroPedido, Date horaEstimadaFinPedido, int tipoEnvio, double totalPedido, boolean bajaPedido, Factura factura, List<DetallePedido> detalles, Usuario usuario, Domicilio domicilio, Estado estado) {

        this.fechaPedido = fechaPedido;
        this.numeroPedido = numeroPedido;
        this.horaEstimadaFinPedido = horaEstimadaFinPedido;
        this.tipoEnvio = tipoEnvio;
        this.totalPedido = totalPedido;
        this.bajaPedido = false;
        this.factura = factura;
        this.detalles = detalles;
        this.usuario = usuario;
        this.domicilio = domicilio;
        this.estado = estado;
    }
}
