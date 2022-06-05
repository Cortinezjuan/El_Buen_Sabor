package com.app.elbuensabor.Entidad;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Configuracion {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idConfiguracion;

    private int cantidadCocineros;
    private String emailEmpresa;
    private String tokenMercadoPago;

}
