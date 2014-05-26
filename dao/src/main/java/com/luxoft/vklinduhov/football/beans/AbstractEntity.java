package com.luxoft.vklinduhov.football.beans;


import org.springframework.data.annotation.Id;

/**
 * Created by Herta on 26.05.2014.
 *
 */

public class AbstractEntity {

    @Id
    protected String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
