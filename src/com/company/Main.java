package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write player 1 name.");
        String p1Name = sc.nextLine();
        System.out.println("Write player 2 name.");
        String p2Name = sc.nextLine();

        Player player1 = new Player(p1Name);
        Player player2 = new Player(p2Name);

        Game game = new Game(player1,player2);
        game.gameStart();

        game.gameplay();
    }
}
