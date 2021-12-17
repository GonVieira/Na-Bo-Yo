package com.company;

import java.util.ArrayList;

public class Field {
    private ArrayList<Monster> monsterZone;
    private ArrayList<Card> graveyard;


    public Field () {
        this.monsterZone = new ArrayList<Monster>();
        this.graveyard = new ArrayList<Card>();

    }

    public void removeMonster (Monster monster) {
        monsterZone.remove(monster);
    }

    public ArrayList<Monster> getMonsterZone() {
        return monsterZone;
    }

    public ArrayList<Card> getGraveyard() {
        return graveyard;
    }

}
