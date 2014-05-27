package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "clubs")
public class Game extends AbstractEntity{

    private Date date;
    private Club clubHome;
    private Club clubAway;
    private Integer homeGoals;
    private Integer awayGoals;


    public Game() {
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Club getClubHome() {
        return clubHome;
    }

    public void setClubHome(Club clubHome) {
        this.clubHome = clubHome;
    }

    public Club getClubAway() {
        return clubAway;
    }

    public void setClubAway(Club clubAway) {
        this.clubAway = clubAway;
    }

    public Integer getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(Integer homeGoals) {
        this.homeGoals = homeGoals;
    }

    public Integer getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(Integer awayGoals) {
        this.awayGoals = awayGoals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Game game = (Game) o;

        if (awayGoals != null ? !awayGoals.equals(game.awayGoals) : game.awayGoals != null) return false;
        if (clubAway != null ? !clubAway.equals(game.clubAway) : game.clubAway != null) return false;
        if (clubHome != null ? !clubHome.equals(game.clubHome) : game.clubHome != null) return false;
        if (date != null ? !date.equals(game.date) : game.date != null) return false;
        if (homeGoals != null ? !homeGoals.equals(game.homeGoals) : game.homeGoals != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = date != null ? date.hashCode() : 0;
        result = 31 * result + (clubHome != null ? clubHome.hashCode() : 0);
        result = 31 * result + (clubAway != null ? clubAway.hashCode() : 0);
        result = 31 * result + (homeGoals != null ? homeGoals.hashCode() : 0);
        result = 31 * result + (awayGoals != null ? awayGoals.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return  date + ": " + homeGoals + " - " + awayGoals;
    }
}
