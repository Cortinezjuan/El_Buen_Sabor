package com.app.elbuensabor.Dto;

import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Entidad.ArticuloManufacturado;
import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloManufacturadoDetalleDto {

    private int idArticuloManufacturadoDetalle;
    private double cantidadArticuloManuDetalle;
    private String unidadMedidaArticuloManuDetalle;

   // relacion
    private ArticuloInsumo articuloInsumo;
    private ArticuloManufacturado articuloMf;
}
