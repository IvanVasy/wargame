package com.softserve.kh05802.wargame;

public class HighVampire extends Vampire{

    public HighVampire() {
        this(5,60,75);
    }

    protected HighVampire(int attack, int health, int vampirism) {
        super(attack, health, vampirism);
    }
}
