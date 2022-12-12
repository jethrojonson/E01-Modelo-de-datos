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
public class CursoOnline {

    @Id
    @GeneratedValue
    private Long id;

    private String nombre;
    private double puntuacion;

    @ManyToOne
    @JoinColumn(
            name= "profesor_id",
            foreignKey = @ForeignKey(name = "FK_CURSO_PROFESOR")
    )
    private Profesor profesor;

    @ToString.Exclude
    @Builder.Default
    @OneToMany(
            mappedBy = "curso",
            fetch = FetchType.EAGER
    )
    private List<Video> videos = new ArrayList<>();

    @PreRemove
    public void setNullVideos(){
        videos.forEach(v -> v.setCurso(null));
    }

    /**********************/
    /* MÉTODOS AUXILIARES */
    /**********************/

    public void addToProfesor(Profesor p){
        this.profesor=p;
        p.getCursos().add(this);
    }

    public void removeFromProfesor(Profesor p){
        this.profesor = null;
        p.getCursos().remove(this);
    }
}
