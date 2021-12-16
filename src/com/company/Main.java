package com.company;

public class Main {

    public static void main(String[] args) {
        Player player1 = new Player("Gon");
        Player player2 = new Player("Dante");

        Game game = new Game(player1,player2);
        game.gameStart();


        game.gameplay();
    }
}
