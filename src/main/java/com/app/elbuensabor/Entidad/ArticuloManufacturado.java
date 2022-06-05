package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public ArticuloManufacturado(int idArticuloManufacturado, int tiempoEstimadoCocina, String denominacionArticuloManu, String imagenArticuloManu) {
        this.idArticuloManufacturado = idArticuloManufacturado;
        this.tiempoEstimadoCocina = tiempoEstimadoCocina;
        this.denominacionArticuloManu = denominacionArticuloManu;
        this.imagenArticuloManu = imagenArticuloManu;
        this.bajaArticuloManu = false;
    }
}