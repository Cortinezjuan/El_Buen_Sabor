package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RolRepositorio extends JpaRepository<Rol, Integer> {

    @Query(value="SELECT * FROM rol WHERE baja_rol = false", nativeQuery = true)
    List<Rol> listarRoles();

    public Rol findBydescripcion(String descripcion);

    @Query(value="SELECT descripcion FROM rol WHERE baja_rol = false", nativeQuery = true)
    List<String> listarRolesString();
}
