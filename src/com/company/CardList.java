package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class CardList {
    public ArrayList<Card> cardList = new ArrayList<>();

    public CardList () {
        cardList.add(new Monster("Dark Magician",2500, 2100));
        cardList.add(new Monster("Blue Eyes White Dragon", 3000, 2500));
        cardList.add(new Monster("Dark Magician Girl", 2000, 1700));
        cardList.add(new Monster("Red Eyes Black Dragon", 3000, 2500));
        cardList.add(new Monster("Buster Blader", 2600, 2300));
        cardList.add(new Monster("Black Luster Soldier", 3000, 2500));
        cardList.add(new Monster("Big Shield Gardna", 100, 2600));
        cardList.add(new Monster("Summoned Skull", 2500, 1200));
        cardList.add(new Monster("Gaia The Fierce Knight", 2300, 2100));
        cardList.add(new Monster("Rude Monster", 1800, 1600));
        cardList.add(new Monster("Curse of Dragon", 2000, 1500));
        cardList.add(new Monster("Mystical Elf", 800, 2000));
    }

    public List<Card> getCardList() {
        return cardList;
    }

}
