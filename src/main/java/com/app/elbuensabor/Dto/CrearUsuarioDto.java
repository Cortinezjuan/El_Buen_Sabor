package com.app.elbuensabor.Dto;

import com.app.elbuensabor.Entidad.Domicilio;
import com.app.elbuensabor.Entidad.Rol;
import lombok.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class CrearUsuarioDto {
    private String nombres;
    private String apellidos;
    private String clave;
    private String email;
    private String usuario;   //Usuario de ingreso para loguearse
    private long telefono;
    boolean bajaUsuario;
    private List<Domicilio> domicilios;
    private String rol;
}
