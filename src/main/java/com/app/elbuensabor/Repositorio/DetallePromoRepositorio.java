package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.DetallePromo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetallePromoRepositorio extends JpaRepository <DetallePromo, Integer> {

}
