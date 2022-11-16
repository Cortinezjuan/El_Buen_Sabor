package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Entidad.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public interface FacturaRepositorio extends JpaRepository<Factura, Integer> {

    @Query(value="SELECT * FROM factura WHERE baja_factura = false ORDER BY fecha_factura", nativeQuery = true)
    List<Factura> listarFacturas();


    //Ingresos (recaudaciones) por períodos de tiempo
    @Query(value="SELECT SUM(total_venta)  " +
            "FROM factura WHERE fecha_factura " +
            "BETWEEN :fecha1 AND :fecha2 AND baja_factura=false", nativeQuery=true)
    Double ingresosPorPeriodo(Date fecha1, Date fecha2);

    @Query(value="SELECT MAX(id_factura) from factura", nativeQuery = true)
    int findIdUltimaFactura();







    //Monto de Ganancia en un periodo de tiempo (ventas – costos)
    @Query(value="SELECT\n" +
            "(SELECT SUM(total_venta) AS ventas  FROM factura" +
            " WHERE fecha_factura BETWEEN :fecha1 AND :fecha2 AND baja_factura=false)-\n" +
            "(SELECT SUM(total_costo) AS ventas  FROM factura " +
            "WHERE fecha_factura BETWEEN :fecha1 AND :fecha2 AND baja_factura=false)\n" +
            "AS DIFERENCIA\n", nativeQuery = true)
    Double gananciaPorPeriodo(Date fecha1, Date fecha2);



}
