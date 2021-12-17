package com.company;


public class Monster extends Card {
    private String name;
    private int attackPower;
    private int defensePower;
    private String mode;


    public Monster(String name, int attackPower, int defensePower) {
        setName(name);
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.mode = mode;
    }

    @Override
    public void printAll() {
        super.printAll();
        System.out.print("Att: " + attackPower + " ");
        System.out.println("Def: " + defensePower);
    }

    @Override
    public void printAll2() {
        super.printAll();
        System.out.print("Att: " + attackPower + " ");
        System.out.print("Def: " + defensePower + " ");
        System.out.println("Mode: " + mode);
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public void changeBattlePosition() {
        if (mode.equalsIgnoreCase("Attack")) {
            setMode("Defence");
        } else {
            setName("Attack");
        }
    }
}
