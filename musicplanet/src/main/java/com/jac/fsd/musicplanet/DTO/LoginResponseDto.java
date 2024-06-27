package com.jac.fsd.musicplanet.DTO;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
    private  String token;
    private  long expiresIn;
}
