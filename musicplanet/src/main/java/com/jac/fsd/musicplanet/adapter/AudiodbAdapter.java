package com.jac.fsd.musicplanet.adapter;

import com.jac.fsd.musicplanet.DTO.DiscographyDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
public class AudiodbAdapter {

    @Value("${audiodb.url}")
    private String apiUrl;
    @Value("${audiodb.key}")
    private String apiKey;


    public DiscographyDTO getDiscography(String artistName) {

        RestTemplate restTemplate = new RestTemplate();

        final String route = apiUrl.concat("{key}/discography.php?s={name}");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("key", apiKey);
        parameters.put("name", artistName);

        DiscographyDTO discographyDTO = restTemplate.getForObject(route, DiscographyDTO.class, parameters);
        return discographyDTO;
    }
}
