package com.app.elbuensabor.Repositorio;


import com.app.elbuensabor.Entidad.PrecioArticuloManufacturado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PrecioArticuloManufacturadoRepositorio extends JpaRepository<PrecioArticuloManufacturado, Integer> {
     @Query(value="SELECT precio_venta_articulo_manufacturado " +
             "FROM precio_articulo_manufacturado " +
             "WHERE id_articulo_manufacturado = :idArticulo ", nativeQuery = true)
     Double findByIdArticuloManufacturado(int idArticulo);
}