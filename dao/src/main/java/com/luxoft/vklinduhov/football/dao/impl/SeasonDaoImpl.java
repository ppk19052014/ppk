package com.luxoft.vklinduhov.football.dao.impl;

import com.luxoft.vklinduhov.football.beans.Season;
import com.luxoft.vklinduhov.football.beans.Season;
import com.luxoft.vklinduhov.football.dao.Dao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Field;
import java.util.List;

@Repository(value = "seasonDao")
public class SeasonDaoImpl implements Dao<Season> {

    private final static ApplicationContext CONTEXT = new GenericXmlApplicationContext("applicationContext-dao.xml");
    private final static MongoOperations mongoOperation = (MongoOperations) CONTEXT.getBean("mongoTemplate");

    private SeasonDaoImpl() {
    }

    @Override
    public void create(Season season) {
        mongoOperation.save(season);
    }

    @Override
    public Season read(String id) {
        Query searchSeasonQuery = new Query(Criteria.where("id").is(id));
        return mongoOperation.findOne(searchSeasonQuery, Season.class);
    }

    public Season readByTournament(String tournamentId) {
        Query searchSeasonQuery = new Query(Criteria.where("tournamentId").is(tournamentId));
        return mongoOperation.findOne(searchSeasonQuery, Season.class);
    }

    @Override
    public void update(Season editSeason) {
        Query searchSeasonQuery = new Query(Criteria.where("id").is(editSeason.getId()));
        for(Field field : editSeason.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                mongoOperation.updateFirst(searchSeasonQuery, Update.update(field.getName(), field.get(editSeason)), Season.class);
            } catch (IllegalAccessException ignored) {
            }

        }
    }

    @Override
    public void delete(String id) {
        Query searchSeasonQuery = new Query(Criteria.where("id").is(id));
        mongoOperation.remove(searchSeasonQuery, Season.class);
    }

    @Override
    public void deleteAll() {
        List<Season> seasonsList = getAll();
        for (int i = 0; i < seasonsList.size(); i++) {
            delete(seasonsList.get(i).getId());
        }
    }

    @Override
    public List<Season> getAll() {
        return mongoOperation.findAll(Season.class);
    }
}
