package com.company;

import java.util.Random;
import java.util.Scanner;

public class Game {
    private Player player1;
    private Player player2;
    private Player turnPlayer;
    private Player opponent;
    private CardList cardList;
    private final int deckSizeLimit = 15;
    private int turns = 0;
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public Game (Player player1, Player player2) {
        this.player1 = player1;
        this.player2 = player2;
        this.cardList = new CardList();
    }

    //Create a deck for each player and place cards in each player hands.
    public void gameStart() {
        createDeck(player1);
        createDeck(player2);
        firstDrawPhase();
    }

    //The game plays until the conditions to stop the loo are met.
    public void gameplay() {
        while (player1.getHP() > 0 && player2.getHP() > 0 && player1.getDeck().getDeck().size() > 0 && player2.getDeck().getDeck().size() > 0) {
            gameTurn(turns++);
        }
        if (player1.getHP() <= 0 || player1.getDeck().getDeck().size() == 0) {
            System.out.println(ANSI_RED_BACKGROUND + player2.getName() + " WON!!!" + ANSI_RESET);
        } else {
            System.out.println(ANSI_PURPLE_BACKGROUND + player1.getName() + " WON!!!" + ANSI_RESET);
        }
    }

    //Selecting the player for each turn
    public void gameTurn (int turns) {
        if (turns % 2 == 0) {
            setTurnPlayer(player1);
            setOpponent(player2);
        } else {
            setTurnPlayer(player2);
            setOpponent(player1);
        }
        if(turns > 0 && turnPlayer.getDeck().getDeck().size() > 0) {
            drawPhase();
        }
        mainPhase1();
        if(turns > 0) {
            battlePhase();
        }
    }

    //Draw phase is the first phase of the turn. In this phase the turn player must draw a card from the deck. if available.
    public void drawPhase() {
        if (turnPlayer.getName().equalsIgnoreCase(player1.getName())) {
            System.out.println(ANSI_PURPLE_BACKGROUND + "                            Turn " + turns + " - " + " Draw Phase! " + "                             \n" + ANSI_RESET);

        } else {
            System.out.println(ANSI_RED_BACKGROUND + "                            Turn " + turns + " - " + " Draw Phase! " + "                             \n" + ANSI_RESET);
        }
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
    }

    //Main phase 1 is the second phase of each turn. In this phase the turn player can choose between summoning a monster
    // or changing the position of a monster already in hte field
    public void mainPhase1() {
        if (turnPlayer.getName().equalsIgnoreCase(player1.getName())) {
            System.out.println(ANSI_PURPLE_BACKGROUND + "                            Turn " + turns + " - " + " Main Phase 1! " + "                      \n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED_BACKGROUND + "                            Turn " + turns + " - " + " Main Phase 1! " + "                      \n" + ANSI_RESET);

        }
        Scanner sc = new Scanner(System.in);
        System.out.println(turnPlayer.getName() + " please choose your move for this phase regarding the following options! \n");
        if (turnPlayer.getField().getMonsterZone().size() == 0) {
            System.out.println("                               SUMMON MONSTER               ");
        } else {
            System.out.println("               SUMMON MONSTER         CHANGE BATTLE POSITION       \n");
        }
        String move = sc.nextLine();

        while (!(move.equalsIgnoreCase("summon monster") || move.equalsIgnoreCase("summon") || move.equalsIgnoreCase("Change battle position"))) {
            System.out.println("Please write a valid answer!");
            move = sc.nextLine();
        }
        //IF SUMMON MONSTER
        if (move.equalsIgnoreCase("summon monster") || (move.equalsIgnoreCase("summon"))) {
            System.out.println("Please choose a monster from your hands. \n");
            turnPlayer.printHand();
            String monsterName = sc.nextLine();
            while (!turnPlayer.checkIfThereIsMonsterInHand(monsterName)){
                System.out.println("Please write a valid monster name to proceed to the next phase!");
                monsterName = sc.nextLine();
            }

            for (int i = 0; i < turnPlayer.getHand().getHand().size(); i++) {
                if (monsterName.equalsIgnoreCase(turnPlayer.getHand().getHand().get(i).getName())) {
                    Card card = turnPlayer.getHand().getHand().get(i);
                    turnPlayer.getField().getMonsterZone().add((Monster) turnPlayer.getHand().playCard(card));
                    System.out.println("Attack mode or Defence mode?");
                    String battlePosition = sc.nextLine();
                    int size = turnPlayer.getField().getMonsterZone().size();
                    while (!(battlePosition.equalsIgnoreCase("attack") || battlePosition.equalsIgnoreCase("attack mode") || battlePosition.equalsIgnoreCase("defence") || battlePosition.equalsIgnoreCase("defence mode"))){
                        System.out.println("Please write a valid answer!!");
                        battlePosition = sc.nextLine();
                    }
                    if (battlePosition.equalsIgnoreCase("Attack") || (battlePosition.equalsIgnoreCase("Attack Mode"))) {
                        turnPlayer.getField().getMonsterZone().get(size - 1).setMode("Attack");
                    }
                    if (battlePosition.equalsIgnoreCase("Defence") || (battlePosition.equalsIgnoreCase("Defence Mode"))) {
                        turnPlayer.getField().getMonsterZone().get(size - 1).setMode("Defence");
                    }
                    break;
                }
            }
        }
        if (move.equalsIgnoreCase("Change battle position")) {
            turnPlayer.printField();
            System.out.println("Select the Monster you want to change battle position.");
            String monsterName = sc.nextLine();
            while (!turnPlayer.checkIfThereIsMonsterInField(monsterName)){
                System.out.println("Please write a valid monster name to proceed to the next phase!");
                monsterName = sc.nextLine();
            }
            for (int j = 0; j < turnPlayer.getField().getMonsterZone().size(); j++) {
                if (turnPlayer.getField().getMonsterZone().get(j).getName().equalsIgnoreCase(monsterName)) {
                    turnPlayer.getField().getMonsterZone().get(j).changeBattlePosition();
                }
            }
        }
    }

    public void battlePhase() {
        if (turnPlayer.getName().equalsIgnoreCase(player1.getName())) {
            System.out.println(ANSI_PURPLE_BACKGROUND + "                             Turn " + turns + " - " + " Battle phase! " + "                            \n" + ANSI_RESET);
        } else {
            System.out.println(ANSI_RED_BACKGROUND + "                             Turn " + turns + " - " + " Battle phase! " + "                            \n" + ANSI_RESET);

        }
        Scanner sc = new Scanner(System.in);
        opponent.printField();
        turnPlayer.printField();
        System.out.println("Write one of the following options. \n");
        System.out.println("       PROCEED TO BATTLE            PASS MY TURN               ");
        String move = sc.nextLine();
        while (!(move.equalsIgnoreCase("Proceed to battle") || move.equalsIgnoreCase("Proceed") || move.equalsIgnoreCase("Pass my turn") || move.equalsIgnoreCase("Pass"))) {
            System.out.println("Please write a valid answer!");
            move = sc.nextLine();
        }
        if (move.equalsIgnoreCase("Proceed to battle") || move.equalsIgnoreCase("Proceed")) {
                startStep();
                while (turnPlayer.checkIfMonsterCanAttack()) {
                    System.out.println("Please choose a monster from your field to attack with.");
                    String monsterName = sc.nextLine();
                        while (!turnPlayer.checkIfThereIsMonsterInField(monsterName)) {
                            System.out.println("Please write a valid monster name to proceed to the next phase!");
                            monsterName = sc.nextLine();
                        }
                        for (int i = 0; i < turnPlayer.getField().getMonsterZone().size(); i++) {
                            if (turnPlayer.getField().getMonsterZone().get(i).getName().equalsIgnoreCase(monsterName)) {
                                while (!turnPlayer.getField().getMonsterZone().get(i).getPosition().equalsIgnoreCase("attack")) {
                                    System.out.println("Please write the name of a monster in ATTACK position!");
                                    monsterName = sc.nextLine();
                                }
                                if (!turnPlayer.getField().getMonsterZone().get(i).getAttacked()) {
                                    Monster attacker = turnPlayer.getField().getMonsterZone().get(i);
                                    opponent.printField();
                                    if (opponent.getField().getMonsterZone().size() == 0) {
                                        System.out.println(opponent.getName() + " has no monsters in their field. You can attack your opponent directly!");
                                        int dmg = attacker.getAttackPower();
                                        opponent.setHP(opponent.getHP() - dmg);
                                        System.out.println("DIRECT HIT!!");
                                        System.out.println(getOpponent().getName() + " lost " + dmg + " HP." + ANSI_RED + opponent.getHP() + " left!" + ANSI_RESET);
                                        attacker.setHaveAttacked(true);
                                        turnPlayer.printFieldDuringBattle();
                                    } else {
                                        System.out.println("Choose one of your opponent monsters that you want to attack.");
                                        String targetName = sc.nextLine();
                                        while (!opponent.checkIfThereIsMonsterInField(targetName)) {
                                            System.out.println("Please write a valid monster name!");
                                            targetName = sc.nextLine();
                                        }
                                        for (int j = 0; j < opponent.getField().getMonsterZone().size(); j++) {
                                            if (opponent.getField().getMonsterZone().get(j).getName().equalsIgnoreCase(targetName)) {
                                                Monster defender = opponent.getField().getMonsterZone().get(j);
                                                damageStep(attacker, defender);
                                                opponent.printFieldDuringBattle();
                                                turnPlayer.printFieldDuringBattle();
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }
                            }
                        }
                    }
        }
        if (move.equalsIgnoreCase("Pass my turn") || move.equalsIgnoreCase("Pass")) {
            System.out.println(turnPlayer.getName() + " passed turn!!");
        }
    }

    public void startStep() {
        for (int i = 0; i < turnPlayer.getField().getMonsterZone().size(); i++) {
            if (turnPlayer.getField().getMonsterZone().get(i).getPosition().equalsIgnoreCase("Defence")) {
                turnPlayer.getField().getMonsterZone().get(i).setHaveAttacked(true);
            } else {
                turnPlayer.getField().getMonsterZone().get(i).setHaveAttacked(false);
            }
        }

        if (turnPlayer.equals(player1)) {
            player2.printField();
        } else {
            player1.printField();
        }
        turnPlayer.printField();
    }

    public void damageStep(Monster attacker, Monster defender) {
        System.out.println(turnPlayer.getName() + " attacked " + opponent.getName() + "'s " + defender.getName() + " with " + attacker.getName() + "." );
        if (defender.getPosition().equalsIgnoreCase("attack")) {
            if (attacker.getAttackPower() < defender.getAttackPower()) {
                int dmg = defender.getAttackPower() - attacker.getAttackPower();
                turnPlayer.setHP(turnPlayer.getHP() - dmg);
                turnPlayer.getField().removeMonsterFromField(attacker);
                System.out.println(opponent.getName() + "'s " + defender.getName() + " destroyed " + turnPlayer.getName() + "'s " + attacker.getName() + "!");
                System.out.println(turnPlayer.getName() + " received " + dmg + " damage. " + ANSI_RED + turnPlayer.getHP() + " left!" + ANSI_RESET);
            }
            if (attacker.getAttackPower() == defender.getAttackPower()) {
                turnPlayer.getField().removeMonsterFromField(attacker);
                opponent.getField().removeMonsterFromField(defender);
                attacker.setHaveAttacked(true);
                System.out.println("Both monsters were destroyed!!");
            }
            if (attacker.getAttackPower() > defender.getAttackPower()) {
                int dmg = attacker.getAttackPower() - defender.getAttackPower();
                opponent.setHP(getOpponent().getHP() - dmg);
                opponent.getField().removeMonsterFromField(defender);
                System.out.println(turnPlayer.getName() + "'s " + attacker.getName() + " destroyed " + opponent.getName() + "'s " + defender.getName() + "!");
                System.out.println(opponent.getName() + " received " + dmg + " damage. " + ANSI_RED + opponent.getHP() + " left!" + ANSI_RESET);
                attacker.setHaveAttacked(true);
            }
        }
        if (defender.getPosition().equalsIgnoreCase("defence")) {
            if (attacker.getAttackPower() < defender.getDefensePower()) {
                int dmg = defender.getDefensePower() - attacker.getAttackPower();
                turnPlayer.setHP(getTurnPlayer().getHP() - dmg);
                System.out.println(turnPlayer.getName() + "'s " + attacker.getName() + " attacked" + opponent.getName() + "' " + defender.getName() + "!");
                System.out.println(opponent.getName() + "' " + defender.getName() + " counter attacked!!!");
                System.out.println(turnPlayer.getName() + " received " + dmg + " damage! " + ANSI_RED + turnPlayer.getHP() +  " left!" + ANSI_RESET);
            }
            if (attacker.getAttackPower() == defender.getDefensePower()) {
                attacker.setHaveAttacked(true);
                System.out.println("Their attack power and defence power is equal!!! None were destroyed.");
            }
            if (attacker.getAttackPower() > defender.getDefensePower()) {
                opponent.getField().removeMonsterFromField(defender);
                attacker.setHaveAttacked(true);
                System.out.println(turnPlayer.getName() + "'s " + attacker.getName() + " destroyed " + opponent.getName() + "'s " + defender.getName() + ".");
            }
        }
    }


    //Deck creation.
    public void createDeck(Player player) {
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

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }
}

