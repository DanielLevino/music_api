package com.daniellevino;
import jakarta.persistence.*;

@Entity
@Table(name = "musics")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String artist;
    private String album;
    private Integer releaseYear;

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
}