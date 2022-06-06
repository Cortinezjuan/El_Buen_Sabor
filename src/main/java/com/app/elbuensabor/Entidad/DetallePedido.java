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
    @ManyToOne
    private Pedido pedido;

    @OneToOne
    private Promo promo;

    @OneToOne
    private ArticuloInsumo articuloInsumo;

    @OneToOne
    private ArticuloManufacturado articuloManufacturado;
}
