package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

/**
 * Created by Vklinduhov on 16.01.14.
 *
 */
@Document(collection = "tournaments")
public class Tournament extends AbstractEntity{

    @Field
    private String name;
    @Field
    private String country;
    @Field
    private List<Club> clubList;

    public Tournament() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<Club> getClubList() {
        return clubList;
    }

    public void setClubList(List<Club> clubList) {
        this.clubList = clubList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tournament that = (Tournament) o;

        if (clubList != null ? !clubList.equals(that.clubList) : that.clubList != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (clubList != null ? clubList.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}