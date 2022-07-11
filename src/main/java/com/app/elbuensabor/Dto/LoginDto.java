package com.app.elbuensabor.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class LoginDto {
    private String usuario;
    private String clave;
    private String rol;
}
