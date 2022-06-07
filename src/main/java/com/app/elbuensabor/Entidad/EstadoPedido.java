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
public class EstadoPedido {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idEstadoPedido;

   @OneToMany(mappedBy = "estadoPedido", cascade = CascadeType.ALL)
   private List<Estado> estados;
}
