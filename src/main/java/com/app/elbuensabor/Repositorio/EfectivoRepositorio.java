package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Efectivo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EfectivoRepositorio extends JpaRepository<Efectivo, Integer> {
}
