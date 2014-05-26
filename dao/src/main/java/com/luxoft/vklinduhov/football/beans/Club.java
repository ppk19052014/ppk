package com.luxoft.vklinduhov.football.beans;

import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "clubs")
public class Club extends AbstractEntity{

    private String name;
//    private Date foundDate;

    public Club() {
    }

    public Club(String name) {
        this.name = name;
    }

    public Club(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Date getFoundDate() {
//        return foundDate;
//    }
//
//    public void setFoundDate(Date foundDate) {
//        this.foundDate = foundDate;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Club club = (Club) o;

        if (name != null ? !name.equals(club.name) : club.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    @Override
    public String toString() {
        return name;
    }
}
