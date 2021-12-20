package com.company.ThePlayer;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;

    public Deck(){
        this.deck = new ArrayList<Card>();
    }

    //Add a card from the card list to the deck.
    public void addCardToDeck(Card card){
        deck.add(card);
    }

    //removes a card from the deck and returns its value.
    public Card drawCard(){
        Card card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

}
