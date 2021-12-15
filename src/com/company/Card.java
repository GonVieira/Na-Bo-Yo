package com.company;


public class Card {
    private String name;

    public Card() {

    }

    //Method for printing every characteristic.
    public void printAll () {
        System.out.print(name + " ----> ");
    }

    public void setName(String name) {
        this.name = name;
    }
}
