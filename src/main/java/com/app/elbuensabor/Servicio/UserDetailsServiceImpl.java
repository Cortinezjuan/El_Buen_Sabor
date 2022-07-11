package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Entidad.Usuario;
import com.app.elbuensabor.Repositorio.UsuarioRepositorio;
import lombok.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    UsuarioRepositorio usuarioRepositorio;



    @Override
    public UserDetails loadUserByUsername(String usuario) throws UsernameNotFoundException {

        Usuario usuario1 = usuarioRepositorio.findByUsuario(usuario);
        Set roles = new HashSet();
        GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuario1.getRol().getDescripcion());
        roles.add(grantedAuthority);
        UserDetails userDetails = (UserDetails) new Usuario(usuario1.getUsuario(),usuario1.getClave(),roles);

        return userDetails;
    }
}
