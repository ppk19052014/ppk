package com.luxoft.vklinduhov.football.dao.impl;

import com.luxoft.vklinduhov.football.beans.Tournament;
import com.luxoft.vklinduhov.football.beans.Player;
import com.luxoft.vklinduhov.football.dao.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository(value = "tournamentDao")
public class TournamentDaoImpl implements Dao<Tournament> {

    private final static ApplicationContext CONTEXT = new GenericXmlApplicationContext("applicationContext-dao.xml");
    private final static MongoOperations mongoOperation = (MongoOperations) CONTEXT.getBean("mongoTemplate");

    private TournamentDaoImpl() {
    }

    @Override
    public void create(Tournament tournament) {
        mongoOperation.save(tournament);
    }

    @Override
    public Tournament read(String id) {
        Query searchTournamentQuery = new Query(Criteria.where("id").is(id));
        return mongoOperation.findOne(searchTournamentQuery, Tournament.class);
    }

    @Override
    public void update(Tournament editTournament) {
        Query searchTournamentQuery = new Query(Criteria.where("id").is(editTournament.getId()));
        for(Field field : editTournament.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                mongoOperation.updateFirst(searchTournamentQuery, Update.update(field.getName(), field.get(editTournament)), Tournament.class);
            } catch (IllegalAccessException ignored) {
            }

        }
    }

    @Override
    public void delete(String id) {
        Query searchTournamentQuery = new Query(Criteria.where("id").is(id));
        mongoOperation.remove(searchTournamentQuery, Tournament.class);
    }

    @Override
    public void deleteAll() {
        List<Tournament> tournamentList = getAll();
        for (int i = 0; i < tournamentList.size(); i++) {
            delete(tournamentList.get(i).getId());
        }
    }

    @Override
    public List<Tournament> getAll() {
        return mongoOperation.findAll(Tournament.class);
    }
}
