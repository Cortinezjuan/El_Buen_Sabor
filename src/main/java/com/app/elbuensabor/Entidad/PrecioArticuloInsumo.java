package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PrecioArticuloInsumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrecio;
    private int idArticuloInsumo;
    private double precioCostoArticuloInsumo;
    private double precioVentaArticuloInsumo;
    @Temporal(TemporalType.DATE)
    private Date fechaPrecioArtInsumo;
    private double cantidadPrecioArtInsumo;
}
