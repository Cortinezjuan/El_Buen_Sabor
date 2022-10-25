package com.app.elbuensabor.Dto;

import com.app.elbuensabor.Entidad.ArticuloManufacturadoDetalle;
import com.app.elbuensabor.Entidad.PrecioArticuloManufacturado;
import com.app.elbuensabor.Entidad.RubroGeneral;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ArticuloManufacturadoDto {
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
