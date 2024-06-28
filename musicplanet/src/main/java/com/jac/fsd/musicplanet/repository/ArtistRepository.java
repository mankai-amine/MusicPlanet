package com.jac.fsd.musicplanet.repository;

import com.jac.fsd.musicplanet.exception.ArtistNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class ArtistRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int getArtistId(String artistName) {
        String sql = "SELECT artist_id FROM artists WHERE artist_name=?";

        // queryForObject doesn't accept artistName directly as a String, we have to wrap it in an Array of Object
        Integer artistId = jdbcTemplate.queryForObject(sql, new Object[]{artistName}, Integer.class);

        if (artistId == null) {
            throw new ArtistNotFoundException("Artist not found: " + artistName);
        }

        return artistId;
    }
}


