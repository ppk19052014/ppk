package com.luxoft.vklinduhov.football.dao;

import com.luxoft.vklinduhov.football.beans.Club;

import java.util.List;

/**
 * Created by vklinduhov on 20.01.14.
 *
 */


public interface ClubDao {

    List<Club> getAllClubs();

    Club getClubById(int id);

    void addClub(Club newClub);

    void removeClubById(int id);

    void editClub(Club editClub);
}
