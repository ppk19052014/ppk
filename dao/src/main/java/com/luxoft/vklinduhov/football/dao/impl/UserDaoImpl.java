package com.luxoft.vklinduhov.football.dao.impl;

import com.luxoft.vklinduhov.football.beans.User;
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

@Repository(value = "userDao")
public class UserDaoImpl implements Dao<User> {

    private final static ApplicationContext CONTEXT = new GenericXmlApplicationContext("applicationContext-dao.xml");
    private final static MongoOperations mongoOperation = (MongoOperations) CONTEXT.getBean("mongoTemplate");

    private UserDaoImpl() {
    }

    @Override
    public void create(User user) {
        mongoOperation.save(user);
    }

    @Override
    public User read(String id) {
        Query searchUserQuery = new Query(Criteria.where("id").is(id));
        return mongoOperation.findOne(searchUserQuery, User.class);
    }

    @Override
    public void update(User editUser) {
        Query searchUserQuery = new Query(Criteria.where("id").is(editUser.getId()));
        for(Field field : editUser.getClass().getDeclaredFields()){
            field.setAccessible(true);
            try {
                mongoOperation.updateFirst(searchUserQuery, Update.update(field.getName(), field.get(editUser)), User.class);
            } catch (IllegalAccessException ignored) {
            }

        }
    }

    @Override
    public void delete(String id) {
        Query searchUserQuery = new Query(Criteria.where("id").is(id));
        mongoOperation.remove(searchUserQuery, User.class);
    }

    @Override
    public List<User> getAll() {
        return mongoOperation.findAll(User.class);
    }
}
