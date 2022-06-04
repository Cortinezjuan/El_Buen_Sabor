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
public class Efectivo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idEfectivo;
    @OneToOne
    private Pago pago;
}
