package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.*;
import com.app.elbuensabor.Entidad.Domicilio;
import com.app.elbuensabor.Entidad.PrecioArticuloInsumo;
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
    BCryptPasswordEncoder passwordEncoders;
    @Autowired
    RolRepositorio rolRepositorio;

    public UsuarioDto listarUsuarioPorId(int id){
        Optional<Usuario> usuarioOptional = usuarioRepositorio.findById(id);
        UsuarioDto usuario = new UsuarioDto();

        try{
            Usuario usuario2 = usuarioOptional.get();

            usuario.setIdUsuario(usuario2.getIdUsuario());
            usuario.setNombres(usuario2.getNombres());
            usuario.setApellidos(usuario2.getApellidos());
            usuario.setEmail(usuario2.getEmail());
            usuario.setUsuario(usuario2.getUsuario());
            usuario.setTelefono(usuario2.getTelefono());
            usuario.setClave( usuario2.getClave());

            try{
                Rol rol = new Rol();
                rol.setIdRol(usuario2.getRol().getIdRol());
                rol.setDescripcion(usuario2.getRol().getDescripcion());
                usuario.setRol((usuario2.getRol().getDescripcion()));

            }catch (Exception e){
                System.out.println(e.getMessage());
            }

            try {
                List<Domicilio> domicilios = new ArrayList<>();

                for (Domicilio dom : usuario2.getDomicilios()) {
                    Domicilio domicilioUsuario = new Domicilio();

                    domicilioUsuario.setIdDomicilio(dom.getIdDomicilio());
                    domicilioUsuario.setCalle(dom.getCalle());
                    domicilioUsuario.setNumeroDomicilio(dom.getNumeroDomicilio());
                    domicilioUsuario.setLocalidad(dom.getLocalidad());

                    domicilios.add(domicilioUsuario);
                }
                usuario.setDomicilios(domicilios);

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return usuario;
    }

    public ResponseEntity<CrearUsuarioDto> crearUsuario(CrearUsuarioDto dto){

        String passEncriptada = passwordEncoders.encode(dto.getClave());
        Rol rolEncontrado = rolRepositorio.findBydescripcion(dto.getRol());
        List<Domicilio> domicilios = new ArrayList<>();
        try {
            for (Domicilio domicilio : dto.getDomicilios()) {
                Domicilio domicilioNuevo = new Domicilio();

                domicilioNuevo.setIdDomicilio(domicilio.getIdDomicilio());
                domicilioNuevo.setCalle(domicilio.getCalle());
                domicilioNuevo.setNumeroDomicilio(domicilio.getNumeroDomicilio());
                domicilioNuevo.setLocalidad(domicilio.getLocalidad());

                domicilios.add(domicilioNuevo);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
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

    public Usuario modificarUsuario(UsuarioDto usuarioDto){

        Rol rolEncontrado = rolRepositorio.findBydescripcion(usuarioDto.getRol());

        Usuario usuario = Usuario.builder()
                .idUsuario(usuarioDto.getIdUsuario())
                .nombres(usuarioDto.getNombres())
                .apellidos(usuarioDto.getApellidos())
                .usuario(usuarioDto.getUsuario())
                .clave(usuarioDto.getClave())
                .email(usuarioDto.getEmail())
                .telefono(usuarioDto.getTelefono())
                .rol(rolEncontrado)
                .domicilios(usuarioDto.getDomicilios())
                .build();

        return usuarioRepositorio.save(usuario);
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

    public List<UsuarioDomRolDto> listarUsuariosEmpleados(){
            List<UsuarioDomRolDto> result = new ArrayList<>();

            for (Usuario usuario2 : usuarioRepositorio.listarUsuariosEmpleados()) {
                UsuarioDomRolDto usuario = new UsuarioDomRolDto();

                usuario.setIdUsuario(usuario2.getIdUsuario());
                usuario.setNombres(usuario2.getNombres());
                usuario.setApellidos(usuario2.getApellidos());
                usuario.setEmail(usuario2.getEmail());
                usuario.setUsuario(usuario2.getUsuario());
                usuario.setTelefono(usuario2.getTelefono());
                usuario.setClave(usuario2.getClave());
                try{
                    Rol rol = new Rol();
                    rol.setIdRol(usuario2.getRol().getIdRol());
                    rol.setDescripcion(usuario2.getRol().getDescripcion());
                    usuario.setRol(rol.getDescripcion());
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                try{
                    List<Domicilio> domicilios = new ArrayList<>();

                    for (Domicilio dom : usuario2.getDomicilios()) {
                        Domicilio domicilio = new Domicilio();
                        domicilio.setIdDomicilio(dom.getIdDomicilio());
                        domicilio.setCalle(dom.getCalle());
                        domicilio.setNumeroDomicilio(dom.getNumeroDomicilio());
                        domicilio.setLocalidad(dom.getLocalidad());
                        domicilios.add(domicilio);
                    }
                    usuario.setDomicilios(domicilios);
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
                result.add(usuario);
            }
            return result;
        }

    public List<UsuarioDomRolDto> listarUsuarios(){
        List<UsuarioDomRolDto> result = new ArrayList<>();

        for (Usuario usuario2 : usuarioRepositorio.listarUsuarios()) {
            UsuarioDomRolDto usuario = new UsuarioDomRolDto();

            usuario.setIdUsuario(usuario2.getIdUsuario());
            usuario.setNombres(usuario2.getNombres());
            usuario.setApellidos(usuario2.getApellidos());
            usuario.setEmail(usuario2.getEmail());
            usuario.setUsuario(usuario2.getUsuario());
            usuario.setTelefono(usuario2.getTelefono());
            usuario.setClave(usuario2.getClave());
            try{
                Rol rol = new Rol();
                rol.setIdRol(usuario2.getRol().getIdRol());
                rol.setDescripcion(usuario2.getRol().getDescripcion());
                usuario.setRol(rol.getDescripcion());
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            try{
                List<Domicilio> domicilios = new ArrayList<>();

                for (Domicilio dom : usuario2.getDomicilios()) {
                    Domicilio domicilio = new Domicilio();
                    domicilio.setIdDomicilio(dom.getIdDomicilio());
                    domicilio.setCalle(dom.getCalle());
                    domicilio.setNumeroDomicilio(dom.getNumeroDomicilio());
                    domicilio.setLocalidad(dom.getLocalidad());
                    domicilios.add(domicilio);
                }
                usuario.setDomicilios(domicilios);
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
            result.add(usuario);
        }
        return result;
    }

    public UsuarioDto getUsuarioBynombreUsuario(String nombreUsuario){
        Usuario usuario = usuarioRepositorio.findByUsuario(nombreUsuario);
        UsuarioDto usuarioDto = UsuarioDto.builder()
                .idUsuario(usuario.getIdUsuario())
                .nombres(usuario.getNombres())
                .apellidos(usuario.getApellidos())
                .clave(usuario.getClave())
                .email(usuario.getEmail())
                .usuario(usuario.getUsuario())
                .telefono(usuario.getTelefono())
                .telefono(usuario.getTelefono())
                .domicilios(usuario.getDomicilios())
                .build();
        return usuarioDto;
    }
}
