package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.RubroGeneral;
import com.app.elbuensabor.Repositorio.RubroGeneralRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RubroGeneralServicio {
    @Autowired
    RubroGeneralRepositorio rubroGeneralRepositorio;

    public List<RubroGeneral> listarRubroGenerales() {
        return rubroGeneralRepositorio.listarRubroGenerales();
    }

    public Optional<RubroGeneral> listarRubroGeneralPorId(int id) {
        return rubroGeneralRepositorio.findById(id);
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
