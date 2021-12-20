package com.company.ThePlayer.TheCards;

import com.company.ThePlayer.Card;
import com.company.ThePlayer.TheCards.Monster;

import java.util.ArrayList;
import java.util.List;

public class CardList {
    public ArrayList<Card> cardList = new ArrayList<>();

    public CardList () {
        cardList.add(new Monster("Dark Magician",2500, 2100));
        cardList.add(new Monster("Blue Eyes White Dragon", 3000, 2500));
        cardList.add(new Monster("Dark Magician Girl", 2000, 1700));
        cardList.add(new Monster("Red Eyes Black Dragon", 2400, 2000));
        cardList.add(new Monster("Buster Blader", 2600, 2300));
        cardList.add(new Monster("Black Luster Soldier", 3000, 2500));
        cardList.add(new Monster("Big Shield Gardna", 100, 2600));
        cardList.add(new Monster("Summoned Skull", 2500, 1200));
        cardList.add(new Monster("Gaia The Fierce Knight", 2300, 2100));
        cardList.add(new Monster("Rude Monster", 1800, 1600));
        cardList.add(new Monster("Curse of Dragon", 2000, 1500));
        cardList.add(new Monster("Mystical Elf", 800, 2000));
        cardList.add(new Monster("Electromagnetic Turtle",0,1800));
        cardList.add(new Monster("Black Luster Soldier",3000,2500));
        cardList.add(new Monster("Archfiend of Gilfer",2200,2500));
        cardList.add(new Monster("Berfomet",1400,1800));
        cardList.add(new Monster("Dark Magician of Chaos",2800,2600));
    }

    public List<Card> getCardList() {
        return cardList;
    }

}
