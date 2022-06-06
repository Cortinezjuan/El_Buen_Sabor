package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class EstadoPedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idEstadoPedido;
    @ManyToOne()
    @JoinColumn(name="idEstado")
    private Estado estado;

    @ManyToOne
    private Pedido pedido;
}
