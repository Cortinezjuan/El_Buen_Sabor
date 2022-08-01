package com.app.elbuensabor.Dto;

import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RubroGeneralDto {
    private int idRubroGeneral;
    private String denominacionRubroGeneral;
    private List<String> articulosManufacturados;
}
