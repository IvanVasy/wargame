package com.softserve.kh05802.wargame;

public class Knight extends Warrior {
    public Knight() {
        super(7, 50);
        this.setMaxHealth(this.getHealth());
    }
}
