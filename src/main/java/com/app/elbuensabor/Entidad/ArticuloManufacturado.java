package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class ArticuloManufacturado {

@Id
@GeneratedValue(strategy= GenerationType.IDENTITY)
private int idArticuloManufacturado;

private int tiempoEstimadoCocina;
private String denominacionArticuloManu;
private String imagenArticuloManu;
private boolean bajaArticuloManu;

//Relaciones
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="idArticuloManufacturado")
    private List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="idArticuloManufacturado")
    private List<PrecioArticuloManufacturado> precioArticuloManufacturados;
    @ManyToOne
    @JoinColumn(name="idRubroGeneral", referencedColumnName = "idRubroGeneral")
    private RubroGeneral rubroGeneral;

    public ArticuloManufacturado(int idArticuloManufacturado, int tiempoEstimadoCocina, String denominacionArticuloManu, String imagenArticuloManu, List<ArticuloManufacturadoDetalle> articuloManufacturadoDetalles, List<PrecioArticuloManufacturado> precioArticuloManufacturados, RubroGeneral rubroGeneral) {
        this.idArticuloManufacturado = idArticuloManufacturado;
        this.tiempoEstimadoCocina = tiempoEstimadoCocina;
        this.denominacionArticuloManu = denominacionArticuloManu;
        this.imagenArticuloManu = imagenArticuloManu;
        this.bajaArticuloManu = false;
        this.articuloManufacturadoDetalles = articuloManufacturadoDetalles;
        this.precioArticuloManufacturados = precioArticuloManufacturados;
        this.rubroGeneral = rubroGeneral;
    }
}