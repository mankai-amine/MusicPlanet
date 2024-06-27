package com.jac.fsd.musicplanet.service;

import com.jac.fsd.musicplanet.adapter.AudiodbAdapter;
import com.jac.fsd.musicplanet.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ArtistService {

    @Autowired
    private ArtistRepository repository;

    @Autowired
    private AudiodbAdapter adapter;

    public int getArtistId(String artistName) {
        return repository.getArtistId(artistName);
    }

    public String getBiography(int artistId) {
        var artistDetailsDTO = adapter.getBiography(artistId);
        // since there is only one artist in our List, we access it with get(0)
        return artistDetailsDTO.getArtistDetails().get(0).getBiography();
    }
}
