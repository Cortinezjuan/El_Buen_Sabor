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
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRol;
    private String descripcion;
    private boolean bajaRol;

    //Relaciones
    @OneToMany
    private List<Usuario> usuarios;

    public Rol(int idRol, String descripcion, List<Usuario> usuarios) {
        this.idRol = idRol;
        this.descripcion = descripcion;
        this.bajaRol = false;
        this.usuarios = usuarios;
    }
}
