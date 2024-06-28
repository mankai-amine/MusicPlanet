package com.jac.fsd.musicplanet.repository;

import com.jac.fsd.musicplanet.model.Track;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackRowMapper implements RowMapper<Track> {

    @Override
    public Track mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Track.builder().trackId(rs.getLong("track_id"))
                .trackName(rs.getString("track_name"))
                .albumId(rs.getLong("album_id"))
                .artistId(rs.getLong("artist_id"))
                .build();
    }
}
