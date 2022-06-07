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
public class Promo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int idPromo;
    private double descuentoPromo;
    private boolean bajaPromo;

    //RELACIONES
    @OneToMany(mappedBy = "promo", cascade = CascadeType.ALL)
    private List<DetallePromo> detallesPromo;
}
