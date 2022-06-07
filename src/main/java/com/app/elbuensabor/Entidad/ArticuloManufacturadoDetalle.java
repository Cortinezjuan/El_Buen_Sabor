package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ArticuloManufacturadoDetalle {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticuloManufacturadoDetalle;
    private int idArticuloManufacturado;
    private int cantidadArticuloManuDetalle;
    private String unidadMedidaArticuloManuDetalle;

    //RELACIONES
    @OneToOne
    private ArticuloInsumo articuloInsumo;
}
