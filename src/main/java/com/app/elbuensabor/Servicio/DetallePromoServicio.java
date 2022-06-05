package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.DetallePromo;
import com.app.elbuensabor.Repositorio.DetallePromoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
public class DetallePromoServicio {
    @Autowired
    DetallePromoRepositorio detallePromoRepositorio;

    public List<DetallePromo> listarDetallesPromo(){
        return detallePromoRepositorio.findAll();
    }

    public Optional<DetallePromo> listarDetallePromoPorId(int id){
        return detallePromoRepositorio.findById(id);
    }

    public DetallePromo guardarDetallesPromo(DetallePromo detallePromo){
        return detallePromoRepositorio.save(detallePromo);
    }

    public DetallePromo modificarDetallesPromo(DetallePromo detallePromo){
        return detallePromoRepositorio.save(detallePromo);
    }
}
