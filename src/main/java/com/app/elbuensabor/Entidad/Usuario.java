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
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String clave;
    private String email;
    private String usuario;   //Usuario de ingreso para loguearse
    private int telefono;
    boolean bajaUsuario;

    //Relaciones
    @OneToMany
    private List<Domicilio> domicilios;
    @ManyToOne
    private Rol rol;

    public Usuario(String nombres, String apellidos, String clave, String email, String usuario, int telefono, List<Domicilio> domicilios, Rol rol) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.clave = clave;
        this.email = email;
        this.usuario = usuario;
        this.telefono = telefono;
        this.bajaUsuario = false;
        this.domicilios = domicilios;
        this.rol = rol;
    }
}
