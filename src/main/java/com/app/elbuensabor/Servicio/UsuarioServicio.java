package com.app.elbuensabor.Servicio;

import com.app.elbuensabor.Dto.CrearUsuarioDto;
import com.app.elbuensabor.Dto.LoginDto;
import com.app.elbuensabor.Dto.LoginRequestDto;
import com.app.elbuensabor.Dto.UsuarioDto;
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
    BCryptPasswordEncoder passwordEncoders;

    public List<UsuarioDto> listarUsuarios(){
        List<UsuarioDto> result = new ArrayList<>();

        for (Usuario usuario2 : usuarioRepositorio.listarUsuarios()) {
            UsuarioDto usuario = new UsuarioDto();

            usuario.setIdUsuario(usuario2.getIdUsuario());
            usuario.setNombres(usuario2.getNombres());
            usuario.setApellidos(usuario2.getApellidos());
            usuario.setEmail(usuario2.getEmail());
            usuario.setUsuario(usuario2.getUsuario());
            usuario.setTelefono(usuario.getTelefono());
            usuario.setClave(usuario2.getClave());

            try{
                Rol rol = new Rol();

                rol.setIdRol(usuario2.getRol().getIdRol());
                rol.setDescripcion(usuario2.getRol().getDescripcion());

                usuario.setRol(rol);

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
        }
        return result;
    }

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
            usuario.setClave(usuario2.getClave());

            try{
                Rol rol = new Rol();
                rol.setIdRol(usuario2.getRol().getIdRol());
                rol.setDescripcion(usuario2.getRol().getDescripcion());
                usuario.setRol(rol);

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

//    public ResponseEntity<CrearUsuarioDto> crearUsuario(CrearUsuarioDto dto){
//
//        String passEncriptada = passwordEncoders.encode(dto.getClave());
//        Rol rolEncontrado = rolRepositorio.findBydescripcion(dto.getRol());
//        List<Domicilio> domicilios = new ArrayList<>();
//        domicilios.add(dto.getDomicilio());
//        Usuario usuario = Usuario.builder()
//                .nombres(dto.getNombres())
//                .apellidos(dto.getApellidos())
//                .usuario(dto.getUsuario())
//                .clave(passEncriptada)
//                .email(dto.getEmail())
//                .telefono(dto.getTelefono())
//                .rol(rolEncontrado)
//                .domicilios(domicilios)
//                .build();
//        usuarioRepositorio.save(usuario);
//        return new ResponseEntity(usuario, HttpStatus.CREATED);
//    }

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

//    public List<UsuarioDto> listarUsuariosEmpleados(){
//        List<Usuario> usuarios = usuarioRepositorio.listarUsuariosEmpleados();
//        List<UsuarioDto> usuarioDtos = new ArrayList<>();
//        for(Usuario aux:usuarios){
//            UsuarioDto usuarioDto = UsuarioDto.builder()
//                    .idUsuario(aux.getIdUsuario())
//                    .nombres(aux.getNombres())
//                    .apellidos(aux.getApellidos())
//                    .email(aux.getEmail())
//                    .usuario(aux.getUsuario())
//                    .telefono(aux.getTelefono())
//                    .rol(aux.getRol().getDescripcion())
//                    .build();
//            usuarioDtos.add(usuarioDto);
//        }
//        return usuarioDtos;
//    }

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
                .build();
        return usuarioDto;
    }
}
