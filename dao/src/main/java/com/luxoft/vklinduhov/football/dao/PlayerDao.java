package com.luxoft.vklinduhov.football.dao;

import com.luxoft.vklinduhov.football.beans.Player;

import java.util.List;

/**
 * Created by vklinduhov on 20.01.14.
 *
 */

public interface PlayerDao {

    void addPlayer(Player newPlayer);

    void removePlayer(int id);

    void editPlayer(Player editPlayer);

    Player getPlayerById(int id);

    List<Player> getAllPLayers();
}
