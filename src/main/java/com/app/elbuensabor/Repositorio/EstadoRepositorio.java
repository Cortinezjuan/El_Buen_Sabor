package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Estado;
import com.app.elbuensabor.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstadoRepositorio extends JpaRepository<Estado, Integer> {
    Estado findByEstado(String estado);
}
