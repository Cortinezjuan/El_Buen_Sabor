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
public class DetallePedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetallePedido;
    private int cantidadDetallePedido;

    //Relaciones
    @ManyToOne()
    @JoinColumn(name="idPedido", referencedColumnName = "idPedido")
    private Pedido pedido;

    @OneToOne
    @JoinColumn(name="idPromo", referencedColumnName = "idPromo")
    private Promo promo;

    @OneToOne
    @JoinColumn(name="idArticuloInsumo", referencedColumnName = "idArticuloInsumo")
    private ArticuloInsumo articuloInsumo;

    @OneToOne
    @JoinColumn(name="idArticuloManufacturado", referencedColumnName = "idArticuloManufacturado")
    private ArticuloManufacturado articuloManufacturado;
}
