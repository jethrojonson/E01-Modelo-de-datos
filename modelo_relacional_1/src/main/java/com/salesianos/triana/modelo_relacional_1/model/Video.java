package com.salesianos.triana.modelo_relacional_1.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Video {

    @Id
    @GeneratedValue
    private Long id;

    private int orden;
    private String titulo;
    private String descripcion;
    private String url;

    @ManyToOne
    @JoinColumn(
            name = "curso_id",
            foreignKey = @ForeignKey(name ="FK_VIDEO_CURSO_ONLINE")
    )
    private CursoOnline curso;

    /**********************/
    /* MÉTODOS AUXILIARES */
    /**********************/

    public void addToCurso(CursoOnline c){
        this.curso = c;
        c.getVideos().add(this);
    }

    public void removeFromCurso(CursoOnline c){
        this.curso = null;
        c.getVideos().remove(this);
    }

}
