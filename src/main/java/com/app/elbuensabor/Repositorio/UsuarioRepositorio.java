package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Usuario;
import com.app.elbuensabor.Entidad.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Integer> {
    @Query(value="SELECT * FROM usuario WHERE baja_usuario = false", nativeQuery = true)
    List<Usuario> listarUsuarios();

    Usuario findByEmail(String email);

    Usuario findByUsuario(String usuario);

}
