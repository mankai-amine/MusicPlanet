package com.jac.fsd.musicplanet.model;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Artist {
    private String artistName;
    private int artistId;
}

