package com.app.elbuensabor.Dto;

import com.app.elbuensabor.Entidad.PrecioArticuloInsumo;
import com.app.elbuensabor.Entidad.RubroArticulo;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
    private List<PrecioArticuloInsumo> preciosArticulosInsumo;
    private RubroArticulo rubroArticulo;
}
