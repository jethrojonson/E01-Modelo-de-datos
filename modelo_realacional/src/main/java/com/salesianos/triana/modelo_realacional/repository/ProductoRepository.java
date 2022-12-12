package com.salesianos.triana.modelo_realacional.repository;

import com.salesianos.triana.modelo_realacional.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
