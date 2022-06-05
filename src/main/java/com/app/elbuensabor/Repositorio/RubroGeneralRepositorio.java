package com.app.elbuensabor.Repositorio;


import com.app.elbuensabor.Entidad.RubroGeneral;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RubroGeneralRepositorio extends JpaRepository<RubroGeneral, Integer> {

    @Query(value="SELECT * FROM rubro_general WHERE baja_rubro_general = false", nativeQuery = true)
    List<RubroGeneral> listarRubroGenerales();
}
