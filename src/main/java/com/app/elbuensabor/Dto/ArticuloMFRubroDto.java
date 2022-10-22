package com.app.elbuensabor.Dto;

import com.app.elbuensabor.Entidad.PrecioArticuloManufacturado;
import com.app.elbuensabor.Entidad.RubroGeneral;
import lombok.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloMFRubroDto {
    private int idArticuloManufacturado;
    private int tiempoEstimadoCocina;
    private String denominacionArticuloManu;
    private String imagenArticuloManu;
    private int stock;
    //relaciones
    private List<PrecioArticuloManufacturado> preciosArticulosManufacturados;
    private List<String> insumos;
    private RubroGeneral rubroGeneral;
}
