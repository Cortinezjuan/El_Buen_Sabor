package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Dto.*;
import com.app.elbuensabor.Entidad.Usuario;
import com.app.elbuensabor.Excepciones.CredencialInvalidaException;
//import com.app.elbuensabor.Servicio.AutenticacionService;
import com.app.elbuensabor.Servicio.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    UsuarioServicio usuarioServicio;

//    @GetMapping("/listarUsuarios")
//    public List<UsuarioDto> listarUsuarios() {
//        return usuarioServicio.listarUsuarios();
//    }

    @GetMapping("/listarUsuarioXId/{id}")
    public UsuarioDto listarUsuarioPorId(@PathVariable("id") int id) {
        return usuarioServicio.listarUsuarioPorId(id);
    }
    @DeleteMapping("/borrarUsuario/{id}")
    public void borrarUsuario(@PathVariable("id") int id) {
        usuarioServicio.borrarUsuario(id);
    }

    @PutMapping("/modificarUsuario")
    public Usuario modificarUsuario(@RequestBody UsuarioDto usuario) {
        return usuarioServicio.modificarUsuario(usuario);
    }

    @PostMapping("/crearUsuario")
    public ResponseEntity<CrearUsuarioDto> crearUsuario(@RequestBody CrearUsuarioDto dto) throws CredencialInvalidaException {
        return usuarioServicio.crearUsuario(dto);
    }

    @GetMapping("/login")
    @ResponseBody
    public LoginDto login (@RequestParam String usuario, @RequestParam String clave) throws CredencialInvalidaException{
        return usuarioServicio.login(usuario,clave);
    }

    @GetMapping("/listarUsuariosEmpleados")
    public List<UsuarioDto> listarPedidosPorUsuario(@RequestParam(name= "nombreUsuario", defaultValue = "null", required = false) String nombreUsuario) {
        return usuarioServicio.listarUsuariosEmpleados();
    }

    @GetMapping("/getUsuarioByNombreUsuario")
    public UsuarioDto getUsuarioBynombreUsuario(@RequestParam(name= "nombreUsuario", defaultValue = "null", required = false) String nombreUsuario){
        return usuarioServicio.getUsuarioBynombreUsuario(nombreUsuario);
    }
}
