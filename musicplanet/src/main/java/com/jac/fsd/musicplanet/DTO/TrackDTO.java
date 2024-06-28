package com.jac.fsd.musicplanet.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class TrackDTO {
    @JsonProperty("idTrack")
    private Long trackId;

    @JsonProperty("strTrack")
    private String trackName;

    @JsonProperty("idAlbum")
    private Long albumId;

    @JsonProperty("idArtist")
    private Long artistId;
}
