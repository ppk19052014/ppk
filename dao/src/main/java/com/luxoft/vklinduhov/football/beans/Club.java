package com.luxoft.vklinduhov.football.beans;

public class Club {

    private int id;
    private String name;

    public Club() {
    }

    public Club(int id) {
        this.id = id;
        //throw new RuntimeException("idCounter++ in Club()");
    }

    public Club(String name) {
        this.name = name;
    }

    public Club(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Club club = (Club) o;

        if (id != club.id) return false;
        if (name != null ? !name.equals(club.name) : club.name != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
