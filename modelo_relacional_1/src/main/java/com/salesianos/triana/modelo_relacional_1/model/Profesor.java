package com.salesianos.triana.modelo_relacional_1.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profesor {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private String email;
    private double puntuacion;

    @ToString.Exclude
    @OneToMany(
            mappedBy = "profesor",
            fetch = FetchType.EAGER
    )
    @Builder.Default
    private List<CursoOnline> cursos = new ArrayList<>();

    @PreRemove
    public void setNullCursos(){
        cursos.forEach(c -> c.setProfesor(null));
    }
}


