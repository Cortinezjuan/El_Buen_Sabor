package com.app.elbuensabor.Dto;

import com.app.elbuensabor.Entidad.Domicilio;
import com.app.elbuensabor.Entidad.Rol;
import lombok.*;
import org.springframework.stereotype.Component;

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
    private int telefono;
    boolean bajaUsuario;
    private Domicilio domicilio;
    private String rol;
}
