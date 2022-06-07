package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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

    //Relación
    @OneToMany(mappedBy = "rubroGeneral", cascade = CascadeType.ALL)
    private List<ArticuloManufacturado> articuloManufacturados;

    public RubroGeneral(int idRubroGeneral, String denominacionRubroGeneral) {
        this.idRubroGeneral = idRubroGeneral;
        this.denominacionRubroGeneral = denominacionRubroGeneral;
        this.bajaRubroGeneral = false;
    }
}
