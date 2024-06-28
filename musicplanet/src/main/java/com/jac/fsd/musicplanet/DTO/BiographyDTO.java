package com.jac.fsd.musicplanet.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class BiographyDTO {
    @JsonProperty("strBiographyEN")
    private String biography;
}
