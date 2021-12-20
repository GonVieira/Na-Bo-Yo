package com.company.ThePlayer.TheCards;


import com.company.ThePlayer.Card;

public class Monster extends Card {
    private String name;
    private int attackPower;
    private int defensePower;
    private String position;
    private boolean attacked;


    public Monster(String name, int attackPower, int defensePower) {
        setName(name);
        this.attackPower = attackPower;
        this.defensePower = defensePower;
        this.position = position;
        this.attacked = attacked;
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
        System.out.println("Position: " + position);
    }

    @Override
    public void printAll3() {
        super.printAll();
        System.out.print("Att: " + attackPower + " ");
        System.out.print("Def: " + defensePower + " ");
        System.out.print("Position: " + position + " ");
        System.out.println("Attacked: " + getAttacked());
    }

    public String getPosition() {
        return position;
    }

    public void setMode(String mode) {
        this.position = mode;
    }

    //Method to change the battle position
    public void changeBattlePosition() {
        if (position.equalsIgnoreCase("Attack")) {
            setMode("Defence");
        } else {
            setMode("Attack");
        }
    }

    public int getAttackPower() {
        return attackPower;
    }

    public int getDefensePower() {
        return defensePower;
    }

    public Boolean getAttacked(){
        return attacked;
    }

    public void setHaveAttacked(Boolean attacked) {
        this.attacked = attacked;
    }
}