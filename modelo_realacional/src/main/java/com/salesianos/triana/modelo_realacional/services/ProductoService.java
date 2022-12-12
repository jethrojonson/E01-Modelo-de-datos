package com.salesianos.triana.modelo_realacional.services;

import com.salesianos.triana.modelo_realacional.model.Producto;
import com.salesianos.triana.modelo_realacional.repository.ProductoRepository;
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
public class ProductoService{

    private final ProductoRepository repository;

    public List<Producto> findAll(){
        return repository.findAll();
    }

    public Producto add(Producto p){
        return repository.save(p);
    }

}
