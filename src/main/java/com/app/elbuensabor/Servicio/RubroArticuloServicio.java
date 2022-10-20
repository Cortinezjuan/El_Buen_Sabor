package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.RubroArticuloDto;
import com.app.elbuensabor.Dto.RubroGeneralDto;
import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Entidad.RubroArticulo;
import com.app.elbuensabor.Entidad.RubroGeneral;
import com.app.elbuensabor.Repositorio.RubroArticuloRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RubroArticuloServicio {

    @Autowired
    RubroArticuloRepositorio rubroArticuloRepositorio;

    public List<RubroArticuloDto> listarRubrosArticulos() {
        List<RubroArticulo> rubros = rubroArticuloRepositorio.findAll();
        List<RubroArticuloDto> rubrosDto = new ArrayList<>();

        for (RubroArticulo aux : rubros) {
            List<String> articulosInsumos = new ArrayList<>();
            if(!(aux.isBajaRubroArticulo())){
                for (ArticuloInsumo art : aux.getArticulosInsumos()) {
                    if(!art.isBajaArticuloInsumo()) {
                        articulosInsumos.add(art.getDenominacionArticuloInsumo());
                    }
                }
                RubroArticuloDto rubroDto = RubroArticuloDto.builder().idRubroArticulo(aux.getIdRubroArticulo())
                        .denominacionRubroArticulo(aux.getDenominacionRubroArticulo())
                        .articulosInsumos(articulosInsumos)
                        .build();
                rubrosDto.add(rubroDto);
            }
        }
        return rubrosDto;
    }


    public RubroArticuloDto listarRubroArticuloPorId(int id) {

            Optional<RubroArticulo> rubroOptional = rubroArticuloRepositorio.findById(id);
            RubroArticuloDto rubro = new RubroArticuloDto();

            try {
                RubroArticulo rubro2 =  rubroOptional.get();
                rubro.setIdRubroArticulo(rubro2.getIdRubroArticulo());
                rubro.setDenominacionRubroArticulo(rubro2.getDenominacionRubroArticulo());

                //se pasa una lista vacia porque se usa otro dto para mostrar este dato
                List<String> articulosInsumo = new ArrayList<>();
                rubro.setArticulosInsumos(articulosInsumo);


            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

            return rubro;
        }

    public RubroArticulo guardarRubroArticulo(RubroArticulo rubroArticulo) {
        return rubroArticuloRepositorio.save(rubroArticulo);
    }

    public void borrarRubroArticulo(int id) {
        Optional<RubroArticulo> rubroArticulo = rubroArticuloRepositorio.findById(id);
        rubroArticulo.get().setBajaRubroArticulo(true);
        rubroArticuloRepositorio.save(rubroArticulo.get());
    }

    public RubroArticulo modificarRubroArticulo(RubroArticulo rubroArticulo) {
        return rubroArticuloRepositorio.save(rubroArticulo);
    }
}
