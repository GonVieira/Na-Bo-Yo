package com.company;

import java.util.ArrayList;

public class Monster extends Card {
    private String name;
    private int attackPower;
    private int defensePower;


    public Monster(String name, int attackPower, int defensePower) {
        setName(name);
        this.attackPower = attackPower;
        this.defensePower = defensePower;
    }

    @Override
    public void printAll() {
        super.printAll();
        System.out.print("Att: " + attackPower + " ");
        System.out.println("Def: " + defensePower);
    }
}
