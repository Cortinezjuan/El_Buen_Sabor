package com.app.elbuensabor.Entidad;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    //RELACIONES
    @OneToMany(mappedBy = "rubroArticulo", cascade = CascadeType.ALL)
    private List<ArticuloInsumo> articulosInsumos;

    public RubroArticulo(int idRubroArticulo, String denominacionRubroArticulo) {
        this.idRubroArticulo = idRubroArticulo;
        this.denominacionRubroArticulo = denominacionRubroArticulo;
        this.bajaRubroArticulo = false;
    }
}
