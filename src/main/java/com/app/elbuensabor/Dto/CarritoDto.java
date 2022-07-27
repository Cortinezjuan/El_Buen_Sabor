package com.app.elbuensabor.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class CarritoDto {
    private int id;
    private String nombreProducto;
    private int cantidad;
    private double precioProducto;
    private double subTotal;
}
