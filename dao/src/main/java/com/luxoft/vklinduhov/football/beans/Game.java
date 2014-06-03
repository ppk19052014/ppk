package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "clubs")
public class Game extends AbstractEntity{

    private String date;
    private String clubHomeId;
    private String clubAwayId;
    private String homeGoals;
    private String awayGoals;


    public Game() {
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getClubHome() {
        return clubHomeId;
    }

    public void setClubHome(String clubHome) {
        this.clubHomeId = clubHome;
    }

    public String getClubAway() {
        return clubAwayId;
    }

    public void setClubAway(String clubAway) {
        this.clubAwayId = clubAway;
    }

    public String getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(String homeGoals) {
        this.homeGoals = homeGoals;
    }

    public String getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(String awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (awayGoals != null ? !awayGoals.equals(game.awayGoals) : game.awayGoals != null) return false;
        if (clubAwayId != null ? !clubAwayId.equals(game.clubAwayId) : game.clubAwayId != null) return false;
        if (clubHomeId != null ? !clubHomeId.equals(game.clubHomeId) : game.clubHomeId != null) return false;
        if (date != null ? !date.equals(game.date) : game.date != null) return false;
        if (homeGoals != null ? !homeGoals.equals(game.homeGoals) : game.homeGoals != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (clubHomeId != null ? clubHomeId.hashCode() : 0);
        result = 31 * result + (clubAwayId != null ? clubAwayId.hashCode() : 0);
        result = 31 * result + (homeGoals != null ? homeGoals.hashCode() : 0);
        result = 31 * result + (awayGoals != null ? awayGoals.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  date + ": " + homeGoals + " - " + awayGoals;
    }
}
