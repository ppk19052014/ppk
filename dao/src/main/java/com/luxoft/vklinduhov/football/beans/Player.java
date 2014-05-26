package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Vklinduhov on 16.01.14.
 *
 */
@Document(collection = "players")
public class Player extends AbstractEntity{

    private String name;
    private Position position;
    private Integer age;
    private Integer height;
    private Integer weight;
    private String clubId;
    private String clubName;

    public Player() {
    }

    public Player(String name, Position position, Integer age, Integer height, Integer weight, String clubId) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.clubId = clubId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getClubId() {
        return clubId;
    }

    public void setClubId(String clubId) {
        this.clubId = clubId;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Player player = (Player) o;

        if (age != player.age) return false;
        if (height != player.height) return false;
        if (weight != player.weight) return false;
        if (clubId != null ? !clubId.equals(player.clubId) : player.clubId != null) return false;
        if (clubName != null ? !clubName.equals(player.clubName) : player.clubName != null) return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (position != player.position) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + age;
        result = 31 * result + height;
        result = 31 * result + weight;
        result = 31 * result + (clubId != null ? clubId.hashCode() : 0);
        result = 31 * result + (clubName != null ? clubName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
