package com.daniellevino;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/musics") // Define um prefixo para todas as rotas desta classe
public class MusicController {

    private final MusicService musicService;
    private final MusicRepository musicRepository;

    public MusicController(MusicService musicService, MusicRepository musicRepository) {
        this.musicService = musicService;
        this.musicRepository = musicRepository;
    }

    @GetMapping
    public List<Music> getAll() {
        return musicService.findAll();
    }

//    @GetMapping("/{id}")
//    public Music getById(Long id){
//        return musicService.findById(id);
//    }

    @PostMapping
    public Music create(@RequestBody Music music) {
        return musicService.save(music);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        try{
            musicService.deleteMusic(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }

    }
}