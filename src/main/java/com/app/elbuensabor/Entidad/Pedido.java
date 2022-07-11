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
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;
    private int numeroPedido;
    private int estadoPedido;
    @Temporal(TemporalType.DATE)
    private Date horaEstimadaFinPedido;
    private int tipoEnvio;
    private double totalPedido;
    @Column(name="baja_pedido")
    private boolean bajaPedido;
    @Transient
    @Column(name="cantidad_pedidos")
    private int cantPedidos;

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
    @OneToMany()
    @JoinColumn(name="idPedido")
    private List<EstadoPedido> estadoPedidos;

    public Pedido(int idPedido, Date fechaPedido, int numeroPedido, int estadoPedido, Date horaEstimadaFinPedido, int tipoEnvio, double totalPedido, Factura factura, List<DetallePedido> detalles, Usuario usuario, Domicilio domicilio,int cantPedidos) {
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
        this.cantPedidos = cantPedidos;
    }
}
