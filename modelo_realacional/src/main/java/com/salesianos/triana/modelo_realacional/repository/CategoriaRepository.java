package com.salesianos.triana.modelo_realacional.repository;

import com.salesianos.triana.modelo_realacional.model.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Long> {
}
