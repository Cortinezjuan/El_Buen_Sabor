package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.RubroGeneralDto;
import com.app.elbuensabor.Entidad.ArticuloManufacturado;
import com.app.elbuensabor.Entidad.RubroGeneral;
import com.app.elbuensabor.Repositorio.RubroGeneralRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RubroGeneralServicio {
    @Autowired
    RubroGeneralRepositorio rubroGeneralRepositorio;

    public List<RubroGeneralDto> listarRubrosGenerales(){
        List<RubroGeneral> rubros = rubroGeneralRepositorio.findAll();
        List<RubroGeneralDto> rubrosDto = new ArrayList<>();

        for (RubroGeneral aux : rubros) {
            List<String> articulosManufacturados = new ArrayList<>();
            if(!(aux.isBajaRubroGeneral())){
                for (ArticuloManufacturado art : aux.getArticuloManufacturados()) {
                    articulosManufacturados.add(art.getDenominacionArticuloManu());
                }
                RubroGeneralDto rubroDto = RubroGeneralDto.builder().idRubroGeneral(aux.getIdRubroGeneral())
                        .denominacionRubroGeneral(aux.getDenominacionRubroGeneral())
                        .articulosManufacturados(articulosManufacturados)
                        .build();
                rubrosDto.add(rubroDto);
            }
        }
        return rubrosDto;
    }

    public RubroGeneralDto listarRubroGeneralPorId(int id) {
        Optional<RubroGeneral> rubroOptional = rubroGeneralRepositorio.findById(id);
        RubroGeneralDto rubro = new RubroGeneralDto();

        try {
            RubroGeneral rubro2 =  rubroOptional.get();
            rubro.setIdRubroGeneral(rubro2.getIdRubroGeneral());
            rubro.setDenominacionRubroGeneral(rubro2.getDenominacionRubroGeneral());

            //se pasa una lista vacia porque se usa otro dto para mostrar este dato
            List<String> articulosMF = new ArrayList<>();
            rubro.setArticulosManufacturados(articulosMF);


        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return rubro;
    }

    public RubroGeneral guardarRubroGeneral(RubroGeneral rubroGeneral) {
        return rubroGeneralRepositorio.save(rubroGeneral);
    }

    public void borrarRubroGeneral(int id) {
        Optional<RubroGeneral> rubroGeneral = rubroGeneralRepositorio.findById(id);
        rubroGeneral.get().setBajaRubroGeneral(true);
        rubroGeneralRepositorio.save(rubroGeneral.get());
    }

    public RubroGeneral modificarRubroGeneral(RubroGeneral rubroGeneral) {
        return rubroGeneralRepositorio.save(rubroGeneral);
    }
}
