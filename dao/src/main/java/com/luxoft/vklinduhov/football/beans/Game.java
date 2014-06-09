package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;
import java.util.List;

@Document(collection = "clubs")
public class Game extends AbstractEntity{

    private String date;
    private String clubHomeId;
    private String clubAwayId;
    private String clubHomeName;
    private String clubAwayName;
    private String homeGoals;
    private String awayGoals;


    public Game() {
    }

    public Game(String clubHomeId, String clubAwayId) {
        this.clubHomeId = clubHomeId;
        this.clubAwayId = clubAwayId;
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

    public String getClubHomeId() {
        return clubHomeId;
    }

    public void setClubHomeId(String clubHomeId) {
        this.clubHomeId = clubHomeId;
    }

    public String getClubAwayId() {
        return clubAwayId;
    }

    public void setClubAwayId(String clubAwayId) {
        this.clubAwayId = clubAwayId;
    }

    public String getClubHomeName() {
        return clubHomeName;
    }

    public void setClubHomeName(String clubHomeName) {
        this.clubHomeName = clubHomeName;
    }

    public String getClubAwayName() {
        return clubAwayName;
    }

    public void setClubAwayName(String clubAwayName) {
        this.clubAwayName = clubAwayName;
    }

    @Override
    public String toString() {
        return clubHomeName + " " + homeGoals + " - " + awayGoals + " " + clubAwayName ;
    }

}
