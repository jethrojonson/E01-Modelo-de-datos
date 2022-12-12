package com.salesianos.triana.modelo_realacional.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Locale;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class Producto {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private double pvp;

    @ManyToOne
    @JoinColumn(
            name = "categoria_id",
            foreignKey = @ForeignKey(name = "FK_PRODUCTO_CATEGORIA")
    )
    private Categoria categoria;

    /**********************/
    /* MÉTODOS AUXILIARES */
    /**********************/

    public void addToCategoria(Categoria c){
        this.categoria = c;
        c.getProductos().add(this);
    }

    public void removeFromCategoria(Categoria c){
        this.categoria = null;
        c.getProductos().remove(this);
    }

}
