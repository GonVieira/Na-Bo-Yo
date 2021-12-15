package com.company;

import java.util.ArrayList;

public class Field {
    private ArrayList<Card> field;

    public Field () {
        this.field = new ArrayList<Card>();
    }

    public ArrayList<Card> getField() {
        return field;
    }
}
