package com.company;

public class Main {

    public static void main(String[] args) {
        Game game = new Game();
        CardList cardList = new CardList();
        Player player1 = new Player("Gon");
        Player player2 = new Player("Dante");

        game.gameStart(player1, player2, cardList);

        player1.printDeck();
        player2.printDeck();

        player1.printHand();
        player2.printHand();
    }
}
