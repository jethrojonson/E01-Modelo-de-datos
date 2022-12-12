package com.salesianos.triana.modelo_relacional_1;

import com.salesianos.triana.modelo_relacional_1.model.CursoOnline;
import com.salesianos.triana.modelo_relacional_1.model.Profesor;
import com.salesianos.triana.modelo_relacional_1.model.Video;
import com.salesianos.triana.modelo_relacional_1.service.CursoOnlineService;
import com.salesianos.triana.modelo_relacional_1.service.ProfesorService;
import com.salesianos.triana.modelo_relacional_1.service.VideoService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static org.hibernate.internal.util.collections.CollectionHelper.listOf;

@Component
@RequiredArgsConstructor
public class MainDeMentira {

    private final VideoService videoService;
    private final CursoOnlineService cursoService;
    private final ProfesorService profesorService;

    @PostConstruct
    public void run(){

        Profesor p1 = Profesor.builder()
                .nombre("Angel Naranjo")
                .email("Angel_nomemolestes@email.com")
                .puntuacion(9.9)
                .build();

        profesorService.add(p1);

        CursoOnline c1 = CursoOnline.builder()
                .nombre("Labores Domesticas")
                .puntuacion(9.4)
                .build();

        CursoOnline c2 = CursoOnline.builder()
                .nombre("Deportes")
                .puntuacion(7.6)
                .build();

        c1.addToProfesor(p1);
        c2.addToProfesor(p1);

        profesorService.add(p1);
        cursoService.addAll(listOf(c1,c2));

        Video v1 = Video.builder()
                .orden(1)
                .titulo("Tijeras Magicas")
                .descripcion("Como hacer unas tijeras que lo cortan todo")
                .url("www.videos-educativos.com")
                .build();

        Video v2 = Video.builder()
                .orden(2)
                .titulo("Comida Sabrosa")
                .descripcion("Como hacer platos exquisitos")
                .url("www.videos-comidas.com")
                .build();

        Video v3 = Video.builder()
                .orden(3)
                .titulo("Escalada")
                .descripcion("Como hacer nudos de escalada")
                .url("www.videos-escalada.com")
                .build();

        Video v4 = Video.builder()
                .orden(4)
                .titulo("Senderismo")
                .descripcion("Como hacer rutas largas")
                .url("www.videos-senderismo.com")
                .build();

        v1.addToCurso(c1);
        v2.addToCurso(c1);
        v3.addToCurso(c2);
        v4.addToCurso(c2);

        cursoService.addAll(listOf(c1,c2));
        videoService.addAll(listOf(v1,v2,v3,v4));

        System.out.println("\n\n");
        p1.getCursos().forEach(c -> System.out.println(c));
        System.out.println();
        c1.getVideos().forEach(v -> System.out.println(v));
        System.out.println();
        c2.getVideos().forEach(v -> System.out.println(v));
        System.out.println();

        cursoService.delete(c1);

        System.out.println(profesorService.findById(1L).get().getCursos());
        System.out.println("\n\n");

        profesorService.delete(p1);













    }
}
