package com.app.elbuensabor.Dto;

import com.app.elbuensabor.Entidad.ArticuloInsumo;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RubroArticuloDto {
    private int idRubroArticulo;
    private String denominacionRubroArticulo;
    private List<String> articulosInsumos;
}
