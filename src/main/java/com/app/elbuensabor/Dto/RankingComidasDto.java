package com.app.elbuensabor.Dto;

import lombok.*;
import org.springframework.stereotype.Component;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Builder
public class RankingComidasDto {
    private String nombreComida;
    private int cantPedida;
}
