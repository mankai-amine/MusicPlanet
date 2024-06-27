package com.jac.fsd.musicplanet.service;

import com.jac.fsd.musicplanet.adapter.AudiodbAdapter;
import com.jac.fsd.musicplanet.model.Album;
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
}
