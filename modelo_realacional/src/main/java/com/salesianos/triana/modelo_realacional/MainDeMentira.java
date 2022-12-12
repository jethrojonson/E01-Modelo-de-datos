package com.salesianos.triana.modelo_realacional;

import com.salesianos.triana.modelo_realacional.model.Categoria;
import com.salesianos.triana.modelo_realacional.model.Producto;
import com.salesianos.triana.modelo_realacional.repository.CategoriaRepository;
import com.salesianos.triana.modelo_realacional.repository.ProductoRepository;
import com.salesianos.triana.modelo_realacional.services.CategoriaService;
import com.salesianos.triana.modelo_realacional.services.ProductoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final ProductoService productoService;
    private final CategoriaService categoriaService;

    @PostConstruct
    public void run() {

        Categoria c1 = Categoria.builder().nombre("Comida").build();
        Categoria c2 = Categoria.builder().nombre("Verdura").build();
        Categoria c3 = Categoria.builder().nombre("Pescado").build();
        categoriaService.add(c1);
        categoriaService.add(c2);
        categoriaService.add(c3);

        Producto p1 = Producto.builder().nombre("Patata").pvp(1.85).build();
        Producto p2 = Producto.builder().nombre("Salmon").pvp(3.45).build();
        productoService.add(p1);
        productoService.add(p2);

        p1.addToCategoria(c2);
        p2.addToCategoria(c3);

        productoService.add(p1);
        productoService.add(p2);

        c3.addCategoriaPadre(c1);
        categoriaService.edit(c3);

        c1.addCategoriaHija(c2);
        categoriaService.edit(c1);

        categoriaService.delete(c1);

    }
}
