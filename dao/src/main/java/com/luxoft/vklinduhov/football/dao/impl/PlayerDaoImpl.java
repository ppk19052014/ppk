package com.luxoft.vklinduhov.football.dao.impl;

import com.luxoft.vklinduhov.football.beans.Player;
import com.luxoft.vklinduhov.football.beans.Position;
import com.luxoft.vklinduhov.football.dao.PlayerDao;
import com.luxoft.vklinduhov.football.dao.mapper.PlayerRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class PlayerDaoImpl implements PlayerDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private PlayerDaoImpl() {
    }

    @Override
    public void addPlayer(Player newPlayer) {

        jdbcTemplate.execute(
                "insert into players(" +
                        "name, " +
                        "position, " +
                        "age, " +
                        "height," +
                        "weight," +
                        "clubId) " +
                        "values (" +
                        "'" + newPlayer.getName() + "'" +
                        "," + "'" + newPlayer.getPosition().getId() + "'" +
                        "," + "'" + newPlayer.getAge() + "'" +
                        "," + "'" + newPlayer.getHeight() + "'" +
                        "," + "'" + newPlayer.getWeight() + "'" +
                        "," + "'" + newPlayer.getClubId() + "'" +
                ");");
    }

    @Override
    public void removePlayer(int id) {
        jdbcTemplate.execute("DELETE FROM players WHERE id=" + id + ";");
    }

    @Override
    public void editPlayer(Player editPlayer) {
//
//        Player player = database.getPlayerSet().get(editPlayer.getId());
//
//        player.setName(editPlayer.getName());
//
//        player.setPosition(editPlayer.getPosition());
//
//        player.setAge(editPlayer.getAge());
//
//        player.setHeight(editPlayer.getHeight());
//
//        player.setWeight(editPlayer.getWeight());
//
//        player.setClubId(editPlayer.getClubId());
    }

    @Override
    public Player getPlayerById(int id) {
        List<Player> playerList = jdbcTemplate.query("SELECT * FROM players WHERE id=" + id + ";", new PlayerRowMapper());
        if (!playerList.isEmpty()) {
            return playerList.get(0);
        }
        return null;
    }

    @Override
    public List<Player> getAllPLayers() {
        List<Player> playerList = new ArrayList<Player>();

//        for(Player player : database.getPlayerSet().values()){
//            playerList.add(player);
//        }

        return playerList;
    }
}
