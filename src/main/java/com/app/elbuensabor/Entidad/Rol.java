package com.app.elbuensabor.Entidad;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    private String descripcion;
    private boolean bajaRol;

    //Relaciones
//    @OneToMany
//    private List<Usuario> usuarios;

    public Rol(String descripcion) {
        this.descripcion = descripcion;
        this.bajaRol = false;
    }
}
