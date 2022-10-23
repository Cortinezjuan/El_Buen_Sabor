package com.app.elbuensabor.Dto;

import com.app.elbuensabor.Entidad.ArticuloInsumo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticuloManufacturadoDetalleDto {

    private int idArticuloManufacturadoDetalle;
    private double cantidadArticuloManuDetalle;
    private String unidadMedidaArticuloManuDetalle;

   // relacion
    private ArticuloInsumo articuloInsumo;
}
