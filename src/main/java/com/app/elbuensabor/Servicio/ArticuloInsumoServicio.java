package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Repositorio.ArticuloInsumoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArticuloInsumoServicio {

    @Autowired
    ArticuloInsumoRepositorio articuloInsumoRepositorio;

    public List<ArticuloInsumo> listarArticulosInsumo(){
        return articuloInsumoRepositorio.listarArticulosInsumo();
    }

    public Optional<ArticuloInsumo> listarArticuloInsumoPorId(int id){
        return articuloInsumoRepositorio.findById(id);
    }

    public ArticuloInsumo guardarArticuloInsumo(ArticuloInsumo articuloInsumo){
        return articuloInsumoRepositorio.save(articuloInsumo);
    }

    public void borrarArticuloInsumo(int id){
        Optional<ArticuloInsumo> articuloInsumo = articuloInsumoRepositorio.findById(id);
        articuloInsumo.get().setBajaArticuloInsumo(true);
        articuloInsumoRepositorio.save(articuloInsumo.get());
    }

    public ArticuloInsumo modificarArticuloInsumo(ArticuloInsumo articuloInsumo){
        return articuloInsumoRepositorio.save(articuloInsumo);
    }
}
