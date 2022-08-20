package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.RubroArticulo;
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

    public List<RubroArticulo> listarRubrosArticulos() {
        return rubroArticuloRepositorio.listarRubrosArticulos();
    }

    //metodo recursivo de rubros
  /*  public List<RubroArticulo> listarSubRubrosPorId(int id) {

        RubroArticulo rubroArecorrer = rubroArticuloRepositorio.buscarPorId(id);
        List<RubroArticulo> listaRecursiva = new ArrayList<>();
        listaRecursion(rubroArecorrer, listaRecursiva);
        return listaRecursiva;

    }*/

   /* public void listaRecursion(RubroArticulo rubro, List<RubroArticulo> listaRubros) {
        listaRubros.add(rubro);
        if (rubro.getRubrosArticulosHijos() != null) {
            for (RubroArticulo rubroHijo : rubro.getRubrosArticulosHijos()) {
                listaRecursion(rubroHijo, listaRubros);
            }
        }
    }*/

    public Optional<RubroArticulo> listarRubroArticuloPorId(int id) {
        return rubroArticuloRepositorio.findById(id);
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
