package com.company;

import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;
    private CardList cardList;
    private final int deckSizeLimit = 15;

    public Game () {
    }

    //Create a deck for each player and place cards in each player hands.
    public void gameStart(Player player1, Player player2, CardList cardList) {
        createDeck(player1, cardList);
        createDeck(player2, cardList);

        drawPhase(player1, player2);
    }

    //Deck creation.
    public void createDeck(Player player, CardList cardList) {
        for (int i = 0; i < deckSizeLimit; i++) {
            int randomCard = new Random().nextInt(cardList.getCardList().size());
            player.getDeck().addCardToDeck(cardList.getCardList().get(randomCard));
        }
    }

    //Place cards in hand.
    public void drawPhase(Player player1, Player player2) {
        player1.firstCards();
        player2.firstCards();
    }
}

