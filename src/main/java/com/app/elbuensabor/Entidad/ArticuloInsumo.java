package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ArticuloInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticuloInsumo;
    private int idRubroArticulo;
    private String denominacionArticuloInsumo;
    private String imagenArticuloInsumo;
    private double stockActual;
    private double stockMinimo;
    private String unidadMedidaArticuloInsumo;
    private boolean esArticuloInsumo;
    private boolean bajaArticuloInsumo;

    public ArticuloInsumo(int idArticuloInsumo, int idRubroArticulo, String denominacionArticuloInsumo, String imagenArticuloInsumo, double stockActual, double stockMinimo, String unidadMedidaArticuloInsumo, boolean esArticuloInsumo, boolean bajaArticuloInsumo) {
        this.idArticuloInsumo = idArticuloInsumo;
        this.idRubroArticulo = idRubroArticulo;
        this.denominacionArticuloInsumo = denominacionArticuloInsumo;
        this.imagenArticuloInsumo = imagenArticuloInsumo;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.unidadMedidaArticuloInsumo = unidadMedidaArticuloInsumo;
        this.esArticuloInsumo = esArticuloInsumo;
        this.bajaArticuloInsumo = false;
    }
}
