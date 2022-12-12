package com.salesianos.triana.modelo_realacional.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Categoria {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;

    @ManyToOne
    private Categoria categoriaPadre;

    @ToString.Exclude
    @OneToMany(
            mappedBy = "categoriaPadre",
            fetch = FetchType.EAGER
    )
    @Builder.Default
    private List<Categoria> categoriasHijas = new ArrayList<>();

    @ToString.Exclude
    @OneToMany(
            mappedBy = "categoria",
            fetch = FetchType.EAGER
    )
    @Builder.Default
    private List<Producto> productos = new ArrayList<>();

    @PreRemove
    public void preRemoveActions(){
        productos.forEach(p -> p.setCategoria(null));
        if(categoriaPadre!=null) {
            categoriaPadre.categoriasHijas.remove(this);
        }
        //HIJAS
        if(!this.getCategoriasHijas().isEmpty())
            this.getCategoriasHijas().forEach(c -> {
                c.setCategoriaPadre(null);
            });
    }

    /**********************/
    /* MÉTODOS AUXILIARES */
    /**********************/

    public void addCategoriaPadre(Categoria c){
        this.setCategoriaPadre(c);
        c.getCategoriasHijas().add(this);
    }

    public void addCategoriaHija(Categoria c){
        this.getCategoriasHijas().add(c);
        c.setCategoriaPadre(this);
    }

    public void removeCategoriaPadre(Categoria c){
        this.setCategoriaPadre(null);
        c.getCategoriasHijas().remove(this);
    }

    public void removeCategoriaHija(Categoria c){
        this.getCategoriasHijas().remove(c);
        c.setCategoriaPadre(null);
    }
}
