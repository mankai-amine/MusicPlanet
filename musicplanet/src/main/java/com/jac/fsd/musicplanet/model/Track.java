package com.jac.fsd.musicplanet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Track {
    private Long trackId;
    private String trackName;
    private Long albumId;
    private Long artistId;
}
