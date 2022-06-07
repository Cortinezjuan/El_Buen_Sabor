package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class ArticuloInsumo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idArticuloInsumo;
    private String denominacionArticuloInsumo;
    private String imagenArticuloInsumo;
    private double stockActual;
    private double stockMinimo;
    private String unidadMedidaArticuloInsumo;
    private boolean esArticuloInsumo;
    private boolean bajaArticuloInsumo;

    //RELACIONES
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="idArticuloInsumo")
    private List<PrecioArticuloInsumo> preciosArticulosInsumo;
    @ManyToOne
    @JoinColumn(name="idRubroArticulo", referencedColumnName = "idRubroArticulo")
    private RubroArticulo rubroArticulo;

    public ArticuloInsumo(int idArticuloInsumo, String denominacionArticuloInsumo, String imagenArticuloInsumo, double stockActual, double stockMinimo, String unidadMedidaArticuloInsumo, boolean esArticuloInsumo) {
        this.idArticuloInsumo = idArticuloInsumo;
        this.denominacionArticuloInsumo = denominacionArticuloInsumo;
        this.imagenArticuloInsumo = imagenArticuloInsumo;
        this.stockActual = stockActual;
        this.stockMinimo = stockMinimo;
        this.unidadMedidaArticuloInsumo = unidadMedidaArticuloInsumo;
        this.esArticuloInsumo = esArticuloInsumo;
        this.bajaArticuloInsumo = false;
    }
}
