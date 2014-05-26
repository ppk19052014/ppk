package com.luxoft.vklinduhov.football.beans;

/**
 * Created by Vklinduhov on 16.01.14.
 *
 */

public enum Position {

    GOALKEEPER("Goalkeeper"), DEFENDER("Defender"), MIDFIELDER("Midfielder"), FORWARD("Forward");

    private String id;

    private Position(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static Position getById(String id){
        for(Position position : Position.values()){
            if (position.id.equals(id)){
                return position;
            }
        }
        return null;
    }
    
}
