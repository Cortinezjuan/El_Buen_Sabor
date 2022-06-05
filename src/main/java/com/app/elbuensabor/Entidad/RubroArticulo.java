package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class RubroArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRubroArticulo;
    private String denominacionRubroArticulo;
    private boolean bajaRubroArticulo;

}
