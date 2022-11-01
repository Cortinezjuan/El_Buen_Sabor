package com.app.elbuensabor.Controlador;

import com.app.elbuensabor.Dto.ArticuloInsumoDto;
import com.app.elbuensabor.Dto.ArticuloMFRubroDto;
import com.app.elbuensabor.Dto.ArticuloManufacturadoDto;
import com.app.elbuensabor.Dto.CarritoDto;
import com.app.elbuensabor.Entidad.ArticuloManufacturado;
import com.app.elbuensabor.Servicio.ArticuloManufacturadoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/articuloManufacturado")
public class ArticuloManufacturadoControlador {

    @Autowired
    ArticuloManufacturadoServicio articuloManufacturadoServicio;

    @GetMapping("/listarArticuloManufacturados")
    public List<ArticuloManufacturadoDto> listarArticuloManufacturados() {
        return articuloManufacturadoServicio.listarArticuloManufacturados();
    }

    //-----------------------------Métodos para ArticuloMFRubroDto-----------------------
    @GetMapping("/listarArticuloManufacturadosRubros")
    public List<ArticuloMFRubroDto> listarArticuloManufacturadosRubro() {
        return articuloManufacturadoServicio.listarArticuloManufacturadosRubro();
    }
    //-----------------------------------------------------------------------------------
    @GetMapping("/listarArticuloManufacturadoXId/{id}")
    public ArticuloMFRubroDto listarArticuloManufacturadoPorId(@PathVariable("id") int id) {
        return articuloManufacturadoServicio.listarArticuloMFPorId(id);
    }

    @PostMapping("/crearArticuloManufacturado")
    @Transactional
    public ResponseEntity<Object> post(@RequestBody ArticuloMFRubroDto dto) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoServicio.guardarArticuloManufacturado(dto));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Error. Please try again later.\"}");
        }
    }

    @DeleteMapping("/borrarArticuloManufacturado/{id}")
    public void borrarArticuloManufacturado(@PathVariable("id") int id) {
        articuloManufacturadoServicio.borrarArticuloManufacturado(id);
    }

    @PutMapping("/modificarArticuloManufacturado/{id}")
    @Transactional
    public ResponseEntity<Object> put(@PathVariable int id, @RequestBody ArticuloMFRubroDto dto ) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(articuloManufacturadoServicio.modificarArticuloManufacturado(dto, id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"message\": \"Error. Please try again later.\"}");
        }
    }

    @PutMapping("/descontarStock")
    public List<CarritoDto> descontarStock(@RequestBody List<CarritoDto> carritosDto){

         return articuloManufacturadoServicio.descontarStock(carritosDto);
    }
}
