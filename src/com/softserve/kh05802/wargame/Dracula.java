package com.softserve.kh05802.wargame;

public class Dracula extends Warlord {

    public Dracula() {
        this(5, 75, 2);
    }

    protected Dracula(int attack, int health, int defense) {
        super(attack, health, defense);
    }

}
