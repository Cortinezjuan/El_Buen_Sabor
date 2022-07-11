package com.app.elbuensabor.Entidad;

import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Domicilio {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idDomicilio;
    private String calle;
    private int numeroDomicilio;
    private String localidad;
    private boolean bajaDomicilio;


    public Domicilio(int idDomicilio, String calle, int numeroDomicilio, String localidad) {
        this.idDomicilio = idDomicilio;
        this.calle = calle;
        this.numeroDomicilio = numeroDomicilio;
        this.localidad = localidad;
        this.bajaDomicilio = false;
    }
}
