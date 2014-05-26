package com.luxoft.vklinduhov.football.dao.impl;

import com.luxoft.vklinduhov.football.beans.Club;
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

@Repository(value = "clubDao")
public class ClubDaoImpl implements Dao<Club> {

    private final static ApplicationContext CONTEXT = new GenericXmlApplicationContext("applicationContext-dao.xml");
    private final static MongoOperations mongoOperation = (MongoOperations) CONTEXT.getBean("mongoTemplate");

    private ClubDaoImpl() {
    }

    @Override
    public void create(Club club) {
        mongoOperation.save(club);
    }

    @Override
    public Club read(String id) {
        Query searchClubQuery = new Query(Criteria.where("id").is(id));
        return mongoOperation.findOne(searchClubQuery, Club.class);
    }

    @Override
    public void update(Club editClub) {
        Query searchClubQuery = new Query(Criteria.where("id").is(editClub.getId()));
        for(Field field : editClub.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                mongoOperation.updateFirst(searchClubQuery, Update.update(field.getName(), field.get(editClub)), Club.class);
            } catch (IllegalAccessException ignored) {
            }

        }
    }

    @Override
    public void delete(String id) {
        Query searchClubQuery = new Query(Criteria.where("id").is(id));
        mongoOperation.remove(searchClubQuery, Club.class);
    }

    @Override
    public List<Club> getAll() {
        return mongoOperation.findAll(Club.class);
    }
}
