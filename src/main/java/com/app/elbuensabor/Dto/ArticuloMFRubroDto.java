package com.app.elbuensabor.Dto;

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
    private double precioTotal;
    private int stock;
    private List<String> insumos;
    private int idRubroGeneral;
}
