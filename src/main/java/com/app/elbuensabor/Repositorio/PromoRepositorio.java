package com.app.elbuensabor.Repositorio;

import com.app.elbuensabor.Entidad.Factura;
import com.app.elbuensabor.Entidad.Promo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PromoRepositorio extends JpaRepository <Promo, Integer> {
    @Query(value="SELECT * FROM promo WHERE baja_promo = false", nativeQuery = true)
    List<Promo> listarPromos();
}
