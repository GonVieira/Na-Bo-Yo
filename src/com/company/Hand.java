package com.company;

import java.util.ArrayList;

public class Hand {
    private ArrayList<Card> hand;
    private final int handSizeLimit = 5;

    public Hand() {
        hand = new ArrayList<>();
    }

    //Draw a card from the deck to the hand.
    public void addCardToHand (Card card) {
        if (hand.size() < handSizeLimit) {
            hand.add(card);
        }
    }


    public ArrayList<Card> getHand() {
        return hand;
    }

    public int getHandSizeLimit() {
        return handSizeLimit;
    }
}
