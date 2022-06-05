package com.app.elbuensabor.Servicio;


import com.app.elbuensabor.Entidad.Promo;
import com.app.elbuensabor.Repositorio.PromoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class PromoServicio {

    @Autowired
    PromoRepositorio promoRepositorio;

    public List<Promo> listarPromos(){
        return promoRepositorio.listarPromos();
    }

    public Optional<Promo> listarPromoPorId(int id){
        return promoRepositorio.findById(id);
    }

    public Promo guardarPromo(Promo promo){
        return promoRepositorio.save(promo);
    }

    public void borrarPromo(int id){
        Optional<Promo> promo = promoRepositorio.findById(id);
        promo.get().setBajaPromo(true);
        promoRepositorio.save(promo.get());
    }

    public Promo modificarPromo(Promo promo){
        return promoRepositorio.save(promo);
    }
}
