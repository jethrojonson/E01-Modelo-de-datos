package com.salesianos.triana.modelo_relacional_1.repository;

import com.salesianos.triana.modelo_relacional_1.model.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfesorRepository extends JpaRepository<Profesor,Long> {
}
