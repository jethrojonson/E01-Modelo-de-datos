package com.salesianos.triana.modelo_relacional_1.service;

import com.salesianos.triana.modelo_relacional_1.model.Profesor;
import com.salesianos.triana.modelo_relacional_1.repository.ProfesorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProfesorService{

    private final ProfesorRepository repository;

    public Optional<Profesor> findById(Long id){
        return repository.findById(id);
    }
    public Profesor add (Profesor profesor){
        return repository.save(profesor);
    }

    public List<Profesor> addAll(List<Profesor> profesores){
        return repository.saveAll(profesores);
    }

    public void delete(Profesor profesor){
        repository.delete(profesor);
    }
}
