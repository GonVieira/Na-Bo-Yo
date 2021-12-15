package com.company;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;


    public Hand() {
        hand = new ArrayList<>();
    }

    //Draw a card from the deck to the hand.
    public void addCardToHand (Card card) {
            hand.add(card);
    }
    public Card playCard(){
        Card card = hand.get(0);
        hand.remove(0);
        return card;
    }


    public ArrayList<Card> getHand() {
        return hand;
    }
}
