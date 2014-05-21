package com.luxoft.vklinduhov.football.dao.mapper;

import com.luxoft.vklinduhov.football.beans.Club;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClubRowMapper implements RowMapper<Club> {
    @Override
    public Club mapRow(ResultSet rs, int rowNum) throws SQLException {
        Club club = new Club();

        int id = rs.getInt("id");
        String name = rs.getString("name");
        club.setId(id);
        club.setName(name);

        return club;
    }
}