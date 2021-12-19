package com.company;

public class Player {
    private String name;
    private int HP = 5000;
    private Deck deck;
    private Hand hand;
    private Field field;
    private final int firstCardsDrawLimit = 5;

    public Player (String name) {
        this.name = name;
        this.deck = new Deck();
        this.hand = new Hand();
        this.field = new Field();
    }

    //Print each player deck with the card information.
    public void printDeck () {
        System.out.println("----------------- " + name + "'s deck" + " -----------------    \n");
        for (int i = 0; i < deck.getDeck().size(); i++) {
            deck.getDeck().get(i).printAll();
        }
        System.out.println("");
    }

    //Print each player hands with the card information.
    public void printHand () {
        System.out.println("----------------- " + name + "'s Cards in Hand" + " ------------------    \n");
        for (int i = 0; i < hand.getHand().size(); i++) {
            hand.getHand().get(i).printAll();
        }
        System.out.println("");
    }

    public void printField () {
        System.out.println("------------------ " + name + "'s Cards in Field" + " ------------------    \n");
        for (int i = 0; i < field.getMonsterZone().size(); i++) {
            field.getMonsterZone().get(i).printAll2();
        }
        System.out.println("");
    }

    //The cards to be placed in the hand of each player in the beginning of the game.
    public void firstCards () {
        for (int i = 0; i < firstCardsDrawLimit; i++) {
            cardsToHand();
        }
    }

    //Draw a card from the deck to the hand
    public void cardsToHand() {
        hand.addCardToHand(deck.drawCard());
    }

    public boolean checkIfThereIsMonsterInHand (String monsterName) {
        for (int i = 0; i < hand.getHand().size(); i++) {
            if (getHand().getHand().get(i).getName().equalsIgnoreCase(monsterName)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfThereIsMonsterInField (String monsterName) {
        for (int i = 0; i < field.getMonsterZone().size(); i++) {
            if (getField().getMonsterZone().get(i).getName().equalsIgnoreCase(monsterName)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkIfMonsterCanAttack () {
        for (int i = 0; i < field.getMonsterZone().size(); i++) {
            if (!field.getMonsterZone().get(i).getAttacked()) {
                return true;
            }
        }
        return false;
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


    public Field getField() {
        return field;
    }
}
