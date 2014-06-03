package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.ArrayList;
import java.util.Collections;
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
    private String membersCount;
    @Field
    private String country;
    @Field
    private List<String> clubListId;

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

    public String getMembersCount() {
        return membersCount;
    }

    public void setMembersCount(String membersCount) {
        this.membersCount = membersCount;
    }

    public boolean addClubId(String clubId){
        Integer maxCount = Integer.valueOf(membersCount);
        if(clubListId == null){
            clubListId = new ArrayList<String>();
        }
        if(maxCount > clubListId.size()){
            clubListId.add(clubId);
            return true;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tournament that = (Tournament) o;

        if (clubListId != null ? !clubListId.equals(that.clubListId) : that.clubListId != null) return false;
        if (country != null ? !country.equals(that.country) : that.country != null) return false;
        if (membersCount != null ? !membersCount.equals(that.membersCount) : that.membersCount != null) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (membersCount != null ? membersCount.hashCode() : 0);
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (clubListId != null ? clubListId.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<String> getAllClubsId() {
        return clubListId == null ? new ArrayList<String>() : new ArrayList<String>(clubListId);
    }
}
