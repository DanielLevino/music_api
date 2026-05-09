package com.daniellevino;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class MusicService {

    private final MusicRepository musicRepository;

    public MusicService(MusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    public List<Music> findAll() {
        return musicRepository.findAll();
    }

//    public Music findById(@PathVariable Long id) {
//        if (!id.equals(1L)){
//            throw new MusicNotFoundException("Music not found");
//        }
//        return musicRepository.findById(id);
//    }

    public Music save(Music music) {
        return musicRepository.save(music);
    }

    public void deleteMusic(Long id) {
        if (musicRepository.existsById(id)) {
            musicRepository.deleteById(id);
        } else {
            throw new RuntimeException("Music not found");
        }
    }

}
