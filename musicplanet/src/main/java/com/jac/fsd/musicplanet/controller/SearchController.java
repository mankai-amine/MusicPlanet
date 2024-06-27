package com.jac.fsd.musicplanet.controller;

import com.jac.fsd.musicplanet.model.Album;
import com.jac.fsd.musicplanet.model.Track;
import com.jac.fsd.musicplanet.repository.TrackRepository;
import com.jac.fsd.musicplanet.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
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

    // TODO REMOVE TEMP CODE
    @Autowired
    private TrackRepository trackRepository;

    @GetMapping("/api/discography/{artistName}")
    public List<Album> getDiscography(@PathVariable String artistName){
        return service.getDiscography(artistName);
    }

    @GetMapping("/api/tracks/{albumId}")
    public List<Track> getTracksByAlbumId(@PathVariable Long albumId) {
        return service.getTracksByAlbumId(albumId);
    }

    // TODO TEMP CODE
    @GetMapping("/api/track/{trackId}")
    public Track getTrackByTrackId(@PathVariable Long trackId) {
        return service.getTrackByTrackId(trackId);
    }

    // TODO remove temp code
    @GetMapping("/api/test/{trackId}")
    public Track getTrackByTrackIdDB(@PathVariable Long trackId) {
        return trackRepository.getTrackById(trackId);
    }
}
