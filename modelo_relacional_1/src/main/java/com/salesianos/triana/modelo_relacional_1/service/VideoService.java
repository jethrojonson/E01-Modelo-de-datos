package com.salesianos.triana.modelo_relacional_1.service;

import com.salesianos.triana.modelo_relacional_1.model.Video;
import com.salesianos.triana.modelo_relacional_1.repository.VideoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VideoService {

    private final VideoRepository repository;

    public Video add (Video video){
        return repository.save(video);
    }

    public List<Video> addAll (List<Video> videos){
        return repository.saveAll(videos);
    }

    public Optional<Video> findById(Long id){
        return repository.findById(id);
    }

    public void delete(Video video) {
        repository.delete(video);
    }
}
