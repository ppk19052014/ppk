package com.luxoft.vklinduhov.football.dao.mapper;

import com.luxoft.vklinduhov.football.beans.Player;
import com.luxoft.vklinduhov.football.beans.Position;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PlayerRowMapper implements RowMapper<Player>{

    @Override
    public Player mapRow(ResultSet rs, int rowNum) throws SQLException {
        Player player = new Player();

        int id = rs.getInt("id");
        String name = rs.getString("name");
        Position position = Position.getById(rs.getString("position"));
        int age = rs.getInt("age");
        int height = rs.getInt("height");
        int weight = rs.getInt("weight");
        int clubId = rs.getInt("clubId");

        player.setId(id);
        player.setName(name);

        return player;
    }
}
