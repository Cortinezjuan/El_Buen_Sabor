package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Dto.ArticuloManufacturadoDetalleDto;
import com.app.elbuensabor.Entidad.ArticuloManufacturadoDetalle;
import com.app.elbuensabor.Servicio.ArticuloManufacturadoDetalleServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/artMfDetalle")
public class ArticuloManufacturadoDetalleControlador {

    @Autowired
    ArticuloManufacturadoDetalleServicio amdServicio;

    @GetMapping("/listarArticulosManuDetalle")
    public List<ArticuloManufacturadoDetalle> listarArticulosManuDetalle() {
        return amdServicio.listarArticulosManuDetalle();
    }

    @GetMapping("/listarArticuloManuDetalleXId/{id}")
    public ArticuloManufacturadoDetalleDto listarArticuloManuDetallePorId(@PathVariable("id") int id) {
        return amdServicio.listarArticulosManuDetallePorId(id);
    }

    @PostMapping("/crearArticuloManuDetalle")
    public ArticuloManufacturadoDetalle crearArticuloManuDetalle(@RequestBody ArticuloManufacturadoDetalle articuloManufacturadoDetalle) {
        return amdServicio.guardarArticuloManuDetalle(articuloManufacturadoDetalle);
    }

    @PutMapping("/modificarArticuloManuDetalle/{id}")
    public ResponseEntity<Object> put(@PathVariable int id, @RequestBody ArticuloManufacturadoDetalleDto dto) {
        try {
        return ResponseEntity.status(HttpStatus.OK).body(amdServicio.modificarArticuloManuDetalle(dto, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Error. Please try again later.\"}");
        }
    }
}
