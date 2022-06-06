package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Estado {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idEstado;
    private String estado;
    @OneToMany(mappedBy = "estado", cascade=CascadeType.ALL)
    private List<EstadoPedido> estadoPedido;

}
