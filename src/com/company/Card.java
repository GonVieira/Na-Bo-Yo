package com.company;


public abstract class Card {
    private String name;

    public Card() {

    }

    //Method for printing every characteristic.
    public void printAll () {
        System.out.print(name + " ----> ");
    }

    public void printAll2() {

    }

    public void printAll3() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
