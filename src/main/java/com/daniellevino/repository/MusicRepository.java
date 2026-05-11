package com.daniellevino.repository;

import com.daniellevino.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicRepository extends JpaRepository<Music, Long> {
    
    boolean existsByTitleAndArtist(String title, String Artist);
}