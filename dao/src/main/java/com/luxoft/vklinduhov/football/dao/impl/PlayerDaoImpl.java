package com.luxoft.vklinduhov.football.dao.impl;

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
import java.util.List;

@Repository(value = "playerDao")
public class PlayerDaoImpl implements Dao<Player> {

    private final static ApplicationContext CONTEXT = new GenericXmlApplicationContext("applicationContext-dao.xml");
    private final static MongoOperations mongoOperation = (MongoOperations) CONTEXT.getBean("mongoTemplate");

    private PlayerDaoImpl() {
    }

    @Override
    public void create(Player player) {
        mongoOperation.save(player);
    }

    @Override
    public Player read(String id) {
        Query searchQuery = new Query(Criteria.where("id").is(id));
        return mongoOperation.findOne(searchQuery, Player.class);
    }

    @Override
    public void update(Player player) {
        Query searchQuery = new Query(Criteria.where("id").is(player.getId()));
        for(Field field : player.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                mongoOperation.updateFirst(searchQuery, Update.update(field.getName(), field.get(player)), Player.class);
            } catch (IllegalAccessException ignored) {
            }

        }
    }

    @Override
    public void delete(String id) {
        Query searchQuery = new Query(Criteria.where("id").is(id));
        mongoOperation.remove(searchQuery, Player.class);
    }

    @Override
    public void deleteAll() {
        List<Player> playerList = getAll();
        for (int i = 0; i < playerList.size(); i++) {
            delete(playerList.get(i).getId());
        }
    }

    @Override
    public List<Player> getAll() {
        return mongoOperation.findAll(Player.class);
    }
}