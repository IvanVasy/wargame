package com.softserve.kh05802.wargame;

public class Ghost extends Warrior {

    public Ghost() {
        this(3, 30);
    }

    protected Ghost(int attack, int health) {
        super(attack, health);
    }

    @Override
    protected int getDamage(Warrior damageDealer) {
        return damageDealer.getAttack() / 2;
    }
}
