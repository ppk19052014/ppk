package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

/**
 * Created by Vklinduhov on 16.01.14.
 *
 */
@Document(collection = "players")
public class Player extends AbstractEntity{

    @Field
    private String name;
    @Field
    private String position;
    @Field
    private String birthsDay;
    @Field
    private String height;
    @Field
    private String weight;
    @Field
    private String clubId;
    @Field
    private String clubName;

    public Player() {
    }

    public Player(String name, String position, String birthsDay, String height, String weight, String clubId) {
        this.name = name;
        this.position = position;
        this.birthsDay = birthsDay;
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

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getBirthsDay() {
        return birthsDay;
    }

    public void setBirthsDay(String birthsDay) {
        this.birthsDay = birthsDay;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
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

        if (birthsDay != null ? !birthsDay.equals(player.birthsDay) : player.birthsDay != null) return false;
        if (clubId != null ? !clubId.equals(player.clubId) : player.clubId != null) return false;
        if (clubName != null ? !clubName.equals(player.clubName) : player.clubName != null) return false;
        if (height != null ? !height.equals(player.height) : player.height != null) return false;
        if (name != null ? !name.equals(player.name) : player.name != null) return false;
        if (position != null ? !position.equals(player.position) : player.position != null) return false;
        if (weight != null ? !weight.equals(player.weight) : player.weight != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + (birthsDay != null ? birthsDay.hashCode() : 0);
        result = 31 * result + (height != null ? height.hashCode() : 0);
        result = 31 * result + (weight != null ? weight.hashCode() : 0);
        result = 31 * result + (clubId != null ? clubId.hashCode() : 0);
        result = 31 * result + (clubName != null ? clubName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
