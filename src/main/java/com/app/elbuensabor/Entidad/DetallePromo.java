package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class DetallePromo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idDetallePromo;
    private int idArticuloInsumo;
    private int idArticuloManufacturado;

    //RELACIONES
    @OneToOne
    private ArticuloInsumo articuloInsumo;
    @OneToOne
    private ArticuloManufacturado articuloManufacturado;
    @ManyToOne
    private Promo promo;
}
