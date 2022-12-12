package com.salesianos.triana.modelo_relacional_1.service;

import com.salesianos.triana.modelo_relacional_1.model.CursoOnline;
import com.salesianos.triana.modelo_relacional_1.repository.CursoOnlineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CursoOnlineService {

    private final CursoOnlineRepository repository;

    public CursoOnline add(CursoOnline cursoOnline){
        return repository.save(cursoOnline);
    }

    public List<CursoOnline> addAll(List<CursoOnline> cursos){
        return repository.saveAll(cursos);
    }

    public Optional<CursoOnline> findById(Long id){
        return repository.findById(id);
    }

    public void delete(CursoOnline cursoOnline){
        repository.delete(cursoOnline);
    }

}
