package com.app.elbuensabor.Dto;

import com.app.elbuensabor.Entidad.PrecioArticuloInsumo;
import com.app.elbuensabor.Entidad.RubroArticulo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloInsumoDto {
    private int idArticuloInsumo;
    private String denominacionArticuloInsumo;
    private String imagenArticuloInsumo;
    private double stockActual;
    private double stockMinimo;
    private String unidadMedidaArticuloInsumo;
    private boolean esArticuloInsumo;
    private boolean bajaArticuloInsumo;
    //relaciones
    private List<Double> preciosArticulosInsumo;
    private String rubroArticulo;
}
