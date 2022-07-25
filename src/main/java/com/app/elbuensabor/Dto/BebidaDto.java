package com.app.elbuensabor.Dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BebidaDto {
    private int idBebida;
    private String nombreBebida;
    private String imagenBebida;
    private double precioTotal;
    private double stock;
}
