package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PrecioArticuloManufacturado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrecioArticuloManufacturado;
    private double PrecioVentaArticuloManufacturado;
    private double PrecioCostoArticuloManufacturado;
    @Temporal(TemporalType.DATE)
    private Date fechaPrecioArtManu;
    private int cantidadPrecioArtManu;
}
