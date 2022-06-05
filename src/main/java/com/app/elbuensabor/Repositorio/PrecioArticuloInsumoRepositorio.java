package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.PrecioArticuloInsumo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioArticuloInsumoRepositorio extends JpaRepository <PrecioArticuloInsumo, Integer> {

}
