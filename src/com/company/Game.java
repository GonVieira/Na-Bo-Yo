package com.company;

import java.util.Random;

public class Game {
    private Player player1;
    private Player player2;
    private Player turnPlayer;
    private CardList cardList;
    private final int deckSizeLimit = 15;
    private int turns = 0;

    public Game (Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.cardList = new CardList();

    }

    //Create a deck for each player and place cards in each player hands.
    public void gameStart() {
        createDeck(player1, cardList);
        createDeck(player2, cardList);
        firstDrawPhase();
    }

    public void gameplay() {
        while (player1.getHP() > 0 && player2.getHP() > 0) {
            gameTurn(turns++);
        }
        if (player1.getHP() > 0) {
            System.out.println(player1.getName() + " WON!!!");
        } else {
            System.out.println(player2.getName() + " WON!!!");
        }
    }

    public void gameTurn (int turns) {
        if (turns % 2 == 0) {
            setTurnPlayer(player1);
        } else {
            setTurnPlayer(player2);
        }
        if(turns > 0) {
            drawPhase(turnPlayer);
        }
    }

    public void drawPhase(Player turnPlayer) {
        System.out.println("---------------------- Turn " + turns + " - " + " Draw Phase! " + "----------------------");
        turnPlayer.getHand().addCardToHand(turnPlayer.getDeck().drawCard());
        int size = turnPlayer.getHand().getHand().size() - 1;
        System.out.println(turnPlayer.getName() + " got " + turnPlayer.getHand().getHand().get(size).getName());
    }


    //Deck creation.
    public void createDeck(Player player, CardList cardList) {
        for (int i = 0; i < deckSizeLimit; i++) {
            int randomCard = new Random().nextInt(cardList.getCardList().size());
            player.getDeck().addCardToDeck(cardList.getCardList().get(randomCard));
        }
    }

    //Place cards in hand.
    public void firstDrawPhase() {
        player1.firstCards();
        player2.firstCards();
    }


    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public Player getTurnPlayer() {
        return turnPlayer;
    }

    public void setTurnPlayer(Player turnPlayer) {
        this.turnPlayer = turnPlayer;
    }
}

