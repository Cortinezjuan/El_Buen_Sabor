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
public class RubroArticulo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRubroArticulo;
    private String denominacionRubroArticulo;
    private boolean bajaRubroArticulo;

    //RELACIONES
    @OneToMany
    private List<ArticuloInsumo> articulosInsumo;
    @OneToOne
    @JoinColumn(name="idRubroArticuloPadre")
    private RubroArticulo rubroArticuloPadre;
    @OneToMany
    private List<RubroArticulo> rubrosArticulosHijos;
}
