package com.daniellevino.service;

import com.daniellevino.excption.MusicNotFoundException;
import com.daniellevino.model.Music;
import com.daniellevino.repository.MusicRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MusicService {

    private final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) { this.musicRepository=musicRepository; }

    // CREATE
    public Music save(Music music) {
        if (musicRepository.existsByTitleAndArtist(music.getTitle(), music.getArtist())){
            throw new RuntimeException("Music Already Exists");
        }
        return musicRepository.save(music);
    }

    // READ
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    public Music findById(@PathVariable Long id) {
        return musicRepository.findById(id).orElseThrow(
            () -> new MusicNotFoundException("Music not found with ID: " + id)
        );
    }

    // UPDATE
    public Music update(Long id, Music upMusic){
        Music music = findById(id);

        if (!music.getTitle().equals(upMusic.getTitle()) || !music.getArtist().equals(upMusic.getArtist())) {
            if (musicRepository.existsByTitleAndArtist(upMusic.getTitle(), upMusic.getArtist())) {
                throw new RuntimeException("Music Already Exist");
            }
        }

        music.setTitle(upMusic.getTitle());
        music.setArtist(upMusic.getArtist());
        music.setAlbum(upMusic.getAlbum());
        music.setReleaseYear(upMusic.getReleaseYear());

        return musicRepository.save(music);
    }

    // DELETE
    public void deleteMusic(Long id) {
        if (musicRepository.existsById(id)) {
            musicRepository.deleteById(id);
        } else {
            throw new RuntimeException("Music not found");
        }
    }

}
