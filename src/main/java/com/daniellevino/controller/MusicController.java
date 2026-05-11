package com.daniellevino.controller;

import java.util.List;

import com.daniellevino.model.Music;
import com.daniellevino.repository.MusicRepository;
import com.daniellevino.service.MusicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/musics")
public class MusicController {

    private final MusicService musicService;
    private final MusicRepository musicRepository;

    public MusicController(MusicService musicService, MusicRepository musicRepository) {
        this.musicService = musicService;
        this.musicRepository = musicRepository;
    }

    // CREATE
    @PostMapping
    public Music create(@Valid @RequestBody Music music) {
        return musicService.save(music);
    }

    // READ
    @GetMapping
    public List<Music> getAll() {
        return musicService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Music> getById(@PathVariable Long id){
        Music music = musicService.findById(id);
        return ResponseEntity.ok(music);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Music> update(@PathVariable Long id, @Valid @RequestBody Music musicDetails) {
        Music updatedMusic = musicService.update(id,musicDetails);
        return ResponseEntity.ok(updatedMusic);
    }

    // DELETE
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