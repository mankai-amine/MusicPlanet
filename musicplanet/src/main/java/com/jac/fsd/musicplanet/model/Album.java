package com.jac.fsd.musicplanet.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class Album {
    private String albumName;
    private int yearOfRelease;
}
