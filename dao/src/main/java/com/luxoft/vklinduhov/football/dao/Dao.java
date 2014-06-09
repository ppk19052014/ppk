package com.luxoft.vklinduhov.football.dao;

import com.luxoft.vklinduhov.football.beans.Club;

import java.util.List;

/**
 * Created by vklinduhov on 20.01.14.
 *
 */


public interface Dao <T> {

    List<T> getAll();

    void create(T newClub);

    T read(String id);

    void update(T editClub);

    void delete(String id);

    void deleteAll();
}
