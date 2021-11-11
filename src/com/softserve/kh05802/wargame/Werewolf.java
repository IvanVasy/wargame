package com.softserve.kh05802.wargame;

public class Werewolf extends Warrior {

    public Werewolf() {
        this(5, 60);
    }

    protected Werewolf(int attack, int health) {
        super(attack, health);
    }
}
