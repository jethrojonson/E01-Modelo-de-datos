package com.salesianos.triana.modelo_realacional.services;

import com.salesianos.triana.modelo_realacional.model.Categoria;
import com.salesianos.triana.modelo_realacional.repository.CategoriaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository repository;

    public Categoria add(Categoria categoria){
        return repository.save(categoria);
    }

    public Categoria edit(Categoria categoria){
        //PADRE
        if(categoria.getCategoriaPadre()!=null) {
            categoria.getCategoriaPadre().getCategoriasHijas().add(categoria);
            repository.save(categoria.getCategoriaPadre());
        }
        //HIJAS
        if(!categoria.getCategoriasHijas().isEmpty())
            categoria.getCategoriasHijas().forEach(c -> {
                c.setCategoriaPadre(categoria);
                repository.save(c);
            });
        return repository.save(categoria);
    }

    public List<Categoria> findAll(){
        return repository.findAll();
    }

    public void delete(Categoria categoria){
        repository.delete(categoria);
    }


}
