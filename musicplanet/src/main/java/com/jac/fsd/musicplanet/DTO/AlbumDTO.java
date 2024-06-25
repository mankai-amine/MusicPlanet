package com.jac.fsd.musicplanet.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class AlbumDTO {
    @JsonProperty("strAlbum")
    private String albumName;

    @JsonProperty("intYearReleased")
    private String yearOfRelease;
}
