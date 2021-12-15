package com.company;

public class Player {
    private String name;
    private int HP = 8000;
    private Deck deck;
    private Hand hand;
    private Graveyard graveyard;
    private Field field;

    public Player (String name) {
        this.name = name;
        this.deck = new Deck();
        this.hand = new Hand();
        this.graveyard = new Graveyard();
    }

    //Print each player deck with the cards information.
    public void printDeck () {
        System.out.println("----------------------" + name + "'s deck" + "----------------------");
        for (int i = 0; i < deck.getDeck().size(); i++) {
            deck.getDeck().get(i).printAll();
        }
    }

    //Print each player hands with the card information.
    public void printHand () {
        System.out.println("----------------------" + name + "'s Cards in Hand" + "----------------------");
        for (int i = 0; i < hand.getHand().size(); i++) {
            hand.getHand().get(i).printAll();
        }
    }

    //The cards to be placed in the hand of each player in the beginning of the game.
    public void firstCards () {
        for (int i = 0; i < hand.getHandSizeLimit(); i++) {
            cardsToHand();
        }
    }

    //Draw a card from the deck to the hand
    public void cardsToHand() {
        hand.addCardToHand(deck.drawCard());
    }



    public void setDeck(Deck deck) {
        this.deck = deck;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Deck getDeck() {
        return deck;
    }

    public int getHP() {
        return HP;
    }

    public void setHP(int HP) {
        this.HP = HP;
    }

    public Hand getHand() {
        return hand;
    }


    public Graveyard getGraveyard() {
        return graveyard;
    }

    public Field getField() {
        return field;
    }
}
