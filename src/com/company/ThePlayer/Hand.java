package com.company.ThePlayer;

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

    public Card playCard(Card card){
        hand.remove(card);
        return card;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }
}
