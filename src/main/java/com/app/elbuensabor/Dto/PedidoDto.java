package com.app.elbuensabor.Dto;


import lombok.*;
import org.springframework.stereotype.Component;
import java.util.Date;



@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class PedidoDto {

    private int idPedido;
    private String fechaPedido;
    private int numeroPedido;
    private int estadoPedido;
    private int horaEstimadaFinPedido;
    private int tipoEnvio;
    private double totalPedido;
    private String nombreUsuario;
}
