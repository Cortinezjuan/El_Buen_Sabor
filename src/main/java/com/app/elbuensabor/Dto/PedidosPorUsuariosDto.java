package com.app.elbuensabor.Dto;

import lombok.*;

@Data
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PedidosPorUsuariosDto {
    private int id_pedido;
    private int id_usuario;
    private int cantidad_Pedidos;
}
