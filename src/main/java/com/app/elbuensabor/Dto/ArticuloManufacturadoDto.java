package com.app.elbuensabor.Dto;

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
    private double precioTotal;
    private int stock;
    private List<String> insumos;

}
