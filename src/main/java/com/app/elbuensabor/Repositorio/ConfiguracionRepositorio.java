package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Configuracion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConfiguracionRepositorio extends JpaRepository<Configuracion, Integer> {
        }

