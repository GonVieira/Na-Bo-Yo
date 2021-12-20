package com.company.ThePlayer;


public abstract class Card {
    private String name;

    public Card() {

    }

    //Method for printing every characteristic.
    public void printAll () {
        System.out.print(name + " ----> ");
    }

    //Method for printing Name,ATK,DEF and position
    public void printAll2() {

    }

    //Method for printing Name, ATK, DEF, Position and if it can attack or not.
    public void printAll3() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
