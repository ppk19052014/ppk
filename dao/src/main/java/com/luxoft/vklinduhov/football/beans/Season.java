package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "seasons")
public class Season extends AbstractEntity{

    @Field
    private String tournamentId;

    @Field
    private String years;

    @Field
    private List<List<Game>> tourList;

    public String getTournamentId() {
        return tournamentId;
    }

    public void setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }

    public List<List<Game>> getTourList() {
        return tourList;
    }

    public void setTourList(List<List<Game>> tourList) {
        this.tourList = tourList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Season season = (Season) o;

        if (tourList != null ? !tourList.equals(season.tourList) : season.tourList != null) return false;
        if (tournamentId != null ? !tournamentId.equals(season.tournamentId) : season.tournamentId != null)
            return false;
        if (years != null ? !years.equals(season.years) : season.years != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = tournamentId != null ? tournamentId.hashCode() : 0;
        result = 31 * result + (years != null ? years.hashCode() : 0);
        result = 31 * result + (tourList != null ? tourList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return tournamentId + ": " + years;
    }
}
