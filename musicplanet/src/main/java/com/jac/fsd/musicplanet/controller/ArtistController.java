package com.jac.fsd.musicplanet.controller;

import com.jac.fsd.musicplanet.service.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping()
public class ArtistController {

    @Autowired
    private ArtistService service;

    @GetMapping("/api/artist/{artistName}")
    public int getArtistId(@PathVariable String artistName){
        return service.getArtistId(artistName);
    }

    // theaudiodb API allows the user to search for artist details (including biography) by entering the artist ID.
    // But the user can't guess which ID belongs to which artist
    // so when the user types the artist name, our method will get the artist ID first, and then it will use the ID to get the biography
    @GetMapping("/api/biography/{artistName}")
    public String getBiography(@PathVariable String artistName){
        int artistId = this.getArtistId(artistName);
        return service.getBiography(artistId);
    }


}
