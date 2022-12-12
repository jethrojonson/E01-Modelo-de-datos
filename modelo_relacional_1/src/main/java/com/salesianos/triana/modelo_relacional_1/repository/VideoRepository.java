package com.salesianos.triana.modelo_relacional_1.repository;

import com.salesianos.triana.modelo_relacional_1.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VideoRepository extends JpaRepository<Video,Long> {
}
