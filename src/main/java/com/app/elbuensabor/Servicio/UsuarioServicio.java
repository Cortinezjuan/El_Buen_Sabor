package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.CrearUsuarioDto;
import com.app.elbuensabor.Dto.LoginDto;
import com.app.elbuensabor.Dto.LoginRequestDto;
import com.app.elbuensabor.Entidad.Domicilio;
import com.app.elbuensabor.Entidad.Rol;
import com.app.elbuensabor.Entidad.Usuario;
import com.app.elbuensabor.Excepciones.CredencialInvalidaException;
import com.app.elbuensabor.Repositorio.RolRepositorio;
import com.app.elbuensabor.Repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServicio {
    
    @Autowired
    UsuarioRepositorio usuarioRepositorio;
    @Autowired
    RolRepositorio rolRepositorio;

    @Autowired
    BCryptPasswordEncoder passwordEncoders;

    public List<Usuario> listarUsuarios(){
        return usuarioRepositorio.listarUsuarios();
    }

    public Optional<Usuario> listarUsuarioPorId(int id){
        return usuarioRepositorio.findById(id);
    }

    public ResponseEntity<CrearUsuarioDto> crearUsuario(CrearUsuarioDto dto){

        String passEncriptada = passwordEncoders.encode(dto.getClave());
        Rol rolEncontrado = rolRepositorio.findBydescripcion(dto.getRol());
        List<Domicilio> domicilios = new ArrayList<>();
        domicilios.add(dto.getDomicilio());
        Usuario usuario = Usuario.builder()
                .nombres(dto.getNombres())
                .apellidos(dto.getApellidos())
                .usuario(dto.getUsuario())
                .clave(passEncriptada)
                .email(dto.getEmail())
                .telefono(dto.getTelefono())
                .rol(rolEncontrado)
                .domicilios(domicilios)
                .build();
        usuarioRepositorio.save(usuario);
        return new ResponseEntity(usuario, HttpStatus.CREATED);
    }

    public void borrarUsuario(int id){
        Optional<Usuario> usuario = usuarioRepositorio.findById(id);
        usuario.get().setBajaUsuario(true);
        usuarioRepositorio.save(usuario.get());

    }

    public Usuario modificarUsuario(Usuario Usuario){
        return usuarioRepositorio.save(Usuario);
    }

    public Usuario listarUsuarioPorEmail(String email){
        return usuarioRepositorio.findByEmail(email);
    }

    public LoginDto login(String usuario, String clave) throws CredencialInvalidaException {
         Usuario usuarioEncontrado = usuarioRepositorio.findByUsuario(usuario);
         if(usuarioEncontrado != null && passwordEncoders.matches(clave, usuarioEncontrado.getClave())){
             LoginDto loginDto = LoginDto.builder()
                     .usuario(usuarioEncontrado.getUsuario())
                     .clave(usuarioEncontrado.getClave())
                     .rol(usuarioEncontrado.getRol().getDescripcion())
                     .build();
             return loginDto;
         }else

             return null;
    }
}
