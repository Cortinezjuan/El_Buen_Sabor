package com.app.elbuensabor.Repositorio;


import com.app.elbuensabor.Entidad.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DomicilioRepositorio extends JpaRepository<Domicilio, Integer> {

    @Query(value="SELECT * FROM domicilio WHERE baja_domicilio = false", nativeQuery = true)
    List<Domicilio> listarDomicilios();

    @Query(value="SELECT * FROM domicilio WHERE id_usuario = :idUsuario", nativeQuery = true)
    Domicilio findByidUsuario(int idUsuario);
}
