package com.app.elbuensabor.Entidad;

import lombok.*;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String clave;
    private String email;
    private String usuario;   //Usuario de ingreso para loguearse
    private long telefono;
    boolean bajaUsuario;

    //Relaciones
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="idUsuario")
    private List<Domicilio> domicilios;
    @ManyToOne
    @JoinColumn(name="idRol")
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

    public Usuario(String usuario, String clave, Set grantList) {
    }
}
