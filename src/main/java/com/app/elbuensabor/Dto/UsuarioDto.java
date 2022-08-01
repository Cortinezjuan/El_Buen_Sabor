package com.app.elbuensabor.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class UsuarioDto {
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String email;
    private String usuario;   //Usuario de ingreso para loguearse
    private int telefono;
    private String clave;
    private String rol;
    boolean bajaUsuario;
}
