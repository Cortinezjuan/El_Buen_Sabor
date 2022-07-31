package com.app.elbuensabor.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class PedidoRespDto {
    private int idPedido;
    private String fechaPedido;
    private int numeroPedido;
    private String estadoPedido;
    private String horaEstimadaFinPedido;
    private int tipoEnvio;
    private double totalPedido;
    private String nombreUsuario;
}
