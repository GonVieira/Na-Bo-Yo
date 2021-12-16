package com.company;

import java.util.Random;
import java.util.Scanner;

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

    //The game plays until the conditions to stop the loo are met.
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

    //Selecting the player for each turn
    public void gameTurn (int turns) {
        if (turns % 2 == 0) {
            setTurnPlayer(player1);
        } else {
            setTurnPlayer(player2);
        }

        if(turns > 0 && turnPlayer.getDeck().getDeck().size() > 0) {
            drawPhase(turnPlayer);
        }
        mainPhase1(turnPlayer);
    }

    //Draw phase is the first phase of the turn. In this phase the turn player must draw a card from the deck. if available.
    public void drawPhase(Player turnPlayer) {
        System.out.println("--------------------------- Turn " + turns + " - " + " Draw Phase! " + "--------------------------- \n");
        Scanner sc = new Scanner(System.in);
        System.out.println("On this phase the turn player should draw a card from the deck.");
        if (turns == 2) {
            System.out.println("Write \"Draw\" to draw a card from your deck." );
        }
        while (true) {
            if (sc.nextLine().equalsIgnoreCase("draw")) {
                turnPlayer.getHand().addCardToHand(turnPlayer.getDeck().drawCard());
                int size = turnPlayer.getHand().getHand().size() - 1;
                System.out.println(turnPlayer.getName() + " got " + turnPlayer.getHand().getHand().get(size).getName());
                break;
            } else {
                System.out.println("Please write \"Draw\" to advance to the next phase!");
            }
        }
        sc.close();
    }

    public void mainPhase1(Player turnPlayer) {
        System.out.println("--------------------------- Turn " + turns + " - " + " Main Phase 1! " + "--------------------------- \n");
        Scanner sc = new Scanner(System.in);
        System.out.println(turnPlayer.getName() + " please choose your move for this phase regarding the following options! \n");
        if (turnPlayer.getField().getField().size() == 0) {
            System.out.println("SUMMON CARD");
        } else {
            System.out.println("                    SUMMON CARD         FLIP CARD         \n");
        }
        String move = sc.nextLine();

        while (true) {
            if (move.equalsIgnoreCase("summon card")) {
                System.out.println("Please choose a card from your hands \n");
                turnPlayer.printHand();
                String monster = sc.nextLine();
                for (int i = 0; i < turnPlayer.getHand().getHand().size(); i++) {
                    if (monster.equalsIgnoreCase(turnPlayer.getHand().getHand().get(i).getName())) {
                        Card card = turnPlayer.getHand().getHand().get(i);
                        turnPlayer.getField().getField().add(turnPlayer.getHand().playCard(card));
                        break;
                    }
                }
            }
            System.out.println("Please write a valid card name to advance to the next phase!");
        }
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

