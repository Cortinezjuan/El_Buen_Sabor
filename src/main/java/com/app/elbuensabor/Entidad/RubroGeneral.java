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
public class RubroGeneral {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idRubroGeneral;

    private String denominacionRubroGeneral;
    private boolean bajaRubroGeneral;


    public RubroGeneral(int idRubroGeneral, String denominacionRubroGeneral) {
        this.idRubroGeneral = idRubroGeneral;
        this.denominacionRubroGeneral = denominacionRubroGeneral;
        this.bajaRubroGeneral = false;
    }
}
