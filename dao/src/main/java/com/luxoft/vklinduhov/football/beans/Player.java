package com.luxoft.vklinduhov.football.beans;

/**
 * Created by Vklinduhov on 16.01.14.
 *
 */

public class Player {

    private int id;
    private String name;
    private Position position;
    private int age;
    private int height;
    private int weight;
    private int clubId;

    public Player() {
    }

    public Player(String name, Position position, int age, int height, int weight, int clubId) {
        this.name = name;
        this.position = position;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.clubId = clubId;
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

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public int getClubId() {
        return clubId;
    }

    public void setClubId(int clubId) {
        this.clubId = clubId;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", age=" + age +
                ", height=" + height +
                ", weight=" + weight +
                ", clubId=" + clubId +
                '}';
    }
}
