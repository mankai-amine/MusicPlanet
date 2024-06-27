package com.jac.fsd.musicplanet.service;

import com.jac.fsd.musicplanet.adapter.AudiodbAdapter;
import com.jac.fsd.musicplanet.model.Album;
import com.jac.fsd.musicplanet.model.Track;
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
        // convert the list of album DTOs into a stream and map each albumDTO to an Album object
        // collect the mapped Album objects into a list
        return discographyDTO.getAlbums().stream()
                .map(albumDTO -> Album.builder()
                        .albumName(albumDTO.getAlbumName())
                        .yearOfRelease(Integer.parseInt(albumDTO.getYearOfRelease()))
                        .build())
                .collect(Collectors.toList());
    }

    public List<Track> getTracksByAlbumId(Long albumId) {
        var trackListDTO = adapter.getTracksByAlbumId(albumId);

        return trackListDTO.getTrackDTOs().stream()
                .map(trackDTO -> Track.builder()
                    .trackId(trackDTO.getTrackId())
                    .trackName(trackDTO.getTrackName())
                    .albumId(trackDTO.getAlbumId())
                    .artistId(trackDTO.getArtistId())
                    .build())
                .collect(Collectors.toList());
    }

    public Track getTrackByTrackId(Long trackID) {
        // audioDb returns a single array element that we must unpack
        var trackDTO = adapter.getTrackByTrackId(trackID).getTrackDTOs().get(0);

        return Track.builder()
                .trackId(trackDTO.getTrackId())
                .trackName(trackDTO.getTrackName())
                .albumId(trackDTO.getAlbumId())
                .artistId(trackDTO.getArtistId())
                .build();
    }

}
