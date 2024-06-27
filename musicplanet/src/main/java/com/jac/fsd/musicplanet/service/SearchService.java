package com.jac.fsd.musicplanet.service;

//import com.jac.fsd.musicplanet.DTO.ArtistIdDTO;
//import com.jac.fsd.musicplanet.DTO.ArtistResponseDTO;
import com.jac.fsd.musicplanet.adapter.AudiodbAdapter;
import com.jac.fsd.musicplanet.model.Album;
import com.jac.fsd.musicplanet.model.Artist;
import com.jac.fsd.musicplanet.model.Biography;
import com.jac.fsd.musicplanet.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {

    @Autowired
    private AudiodbAdapter adapter;


    public List<Album> getDiscography(String artistName) {
        var discographyDTO = adapter.getDiscography(artistName);
        // map each albumDTO to an Album object and collect the mapped Album objects into a list
        return discographyDTO.getAlbums().stream()
                .map(albumDTO -> Album.builder()
                        .albumName(albumDTO.getAlbumName())
                        .yearOfRelease(Integer.parseInt(albumDTO.getYearOfRelease()))
                        .build())
                .collect(Collectors.toList());
    }


    @Autowired
    private ArtistRepository repository;

    public Artist getArtistId(String theArtistName) {
        var theArtistId = repository.getArtistId(theArtistName);
        Artist artistObj =  Artist.builder()
                .artistName(theArtistName)
                .artistId(theArtistId)
                .build();
        return artistObj;
    }

    public Biography getBiography(int artistId) {
        var artistDetailsDTO = adapter.getBiography(artistId);
        // since there is only one artist in our List, we access it with get(0)
        String biographyStr = artistDetailsDTO.getArtistDetails().get(0).getBiography();
        Biography biographyObj = Biography.builder()
                .biography(biographyStr).build();

        return biographyObj;
    }
}
