package com.jac.fsd.musicplanet.controller;

import com.jac.fsd.musicplanet.model.Album;
import com.jac.fsd.musicplanet.model.Artist;
import com.jac.fsd.musicplanet.model.Biography;
import com.jac.fsd.musicplanet.model.Track;
import com.jac.fsd.musicplanet.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping()
public class SearchController {

    @Autowired
    private SearchService service;

    @GetMapping("/api/discography/{artistName}")
    public ResponseEntity<List<Album>> getDiscography(@PathVariable String artistName){
        return new ResponseEntity<>(service.getDiscography(artistName), HttpStatus.OK);
    }

    @GetMapping("/api/artist/{artistName}")
    public ResponseEntity<Artist> getArtistIdByName(@PathVariable String artistName){
        return new ResponseEntity<>(service.getArtistId(artistName), HttpStatus.OK) ;
    }

    // theaudiodb API allows the user to search for artist details (including biography) by entering the artist ID.
    // But the user can't guess which ID belongs to which artist
    // so when the user types the artist name, our method will get the artist ID first, and then it will use the ID to get the biography
    @GetMapping("/api/biography/{artistName}")
    public ResponseEntity<Biography> getBiography(@PathVariable String artistName){
        ResponseEntity<Artist> artistResponseEntity = this.getArtistIdByName(artistName);
        if (artistResponseEntity.getStatusCode() == HttpStatus.OK && artistResponseEntity.getBody() != null){
            int artistId = artistResponseEntity.getBody().getArtistId();
            return new ResponseEntity<>(service.getBiography(artistId), HttpStatus.OK) ;
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/api/tracks/{albumId}")
    public List<Track> getTracksByAlbumId(@PathVariable Long albumId) {
        return service.getTracksByAlbumId(albumId);
    }

    @GetMapping("/api/track/{trackId}")
    public Track getTrackByTrackId(@PathVariable Long trackId) {
        return service.getTrackByTrackId(trackId);
    }

}
