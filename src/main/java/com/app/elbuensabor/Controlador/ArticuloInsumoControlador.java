package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Dto.ArticuloInsumoDto;
import com.app.elbuensabor.Dto.BebidaDto;
import com.app.elbuensabor.Entidad.ArticuloInsumo;
import com.app.elbuensabor.Servicio.ArticuloInsumoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/articuloInsumo")
public class ArticuloInsumoControlador {
    
    @Autowired
    ArticuloInsumoServicio articuloInsumoServicio;

    @GetMapping("/listarArticulosInsumo")
    public List<ArticuloInsumoDto> listarArticulosInsumo(){
        return articuloInsumoServicio.listarArticulosInsumo();
    }

    @GetMapping("/articuloInsumoXId/{id}")
    public ArticuloInsumoDto articuloInsumoPorId(@PathVariable("id") int id) {
        return articuloInsumoServicio.articuloInsumoPorId(id);
    }

    @PostMapping("/crearArticuloInsumo")
    @Transactional
    public ResponseEntity<Object> post(@RequestBody ArticuloInsumoDto dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(articuloInsumoServicio.guardarArticuloInsumo(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Error. Please try again later.\"}");
        }
    }

    @DeleteMapping("/borrarArticuloInsumo/{id}")
    public void borrarArticuloInsumo(@PathVariable("id") int id) {
        articuloInsumoServicio.borrarArticuloInsumo(id);
    }

    @PutMapping("/modificarArticuloInsumo")
    @Transactional
    public ResponseEntity<Object> put(@PathVariable int id, @RequestBody ArticuloInsumoDto dto ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(articuloInsumoServicio.modificarArticuloInsumo(dto, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Error. Please try again later.\"}");
        }
    }

    //Lista solo las bebidas
    @GetMapping("/listarBebidas")
    public List<BebidaDto> listarBebidas(){
        return articuloInsumoServicio.listarBebidas();
    }
}
