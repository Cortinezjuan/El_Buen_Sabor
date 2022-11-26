package com.app.elbuensabor.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class FacturaDto {
    private int idFactura;
    private String fechaFactura;
    private int numeroFactura;
    private double porcentajeDescuento;
    private double totalVenta;
    private double totalCosto;
    private boolean bajaFactura;
}
