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
public class UsuarioDto {
    private int idUsuario;
    private String nombres;
    private String apellidos;
    private String email;
    private String usuario;
    private int telefono;
    private String clave;
    boolean bajaUsuario;
    //relaciones
    private String rol;
    private List<Domicilio> domicilios;
}
