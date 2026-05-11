package com.daniellevino.model;
import jakarta.persistence.*;
import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Max;

import java.time.Year;

@Entity
@Table(name = "musics")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Required Title")
    private String title;

    @NotBlank(message = "Required Artist")
    private String artist;

    private String album;
    private Integer releaseYear;

    @AssertTrue(message = "Future Year Not Allowed")
    private boolean isReleaseYearValid() {
        int currentYear = Year.now().getValue();
        return this.releaseYear <= currentYear;
    }

    public Music() {}

    public Music(String title, String artist, String album, Integer releaseYear) {
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.releaseYear = releaseYear;
    }

    // Getters
    public Long getId() { return id; }
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public String getAlbum() { return album; }
    public Integer getReleaseYear() { return releaseYear; }

    // Setters
    public void setTitle(String title) { this.title = title; }
    public void setArtist(String artist) { this.artist =  artist; }
    public void setAlbum(String album) { this.album = album; }
    public void setReleaseYear(Integer releaseYear) { this.releaseYear = releaseYear; }

}