package com.softserve.kh05802.wargame;

public class Healer extends Warrior {
    private int healing = 2;

    public Healer() {
        this(0, 60, 2);
    }


    protected Healer(int attack, int health, int healing) {
        super(attack, health);
        this.setMaxHealth(this.getHealth());
        setHealing(healing);
    }

    public void heal(Warrior warrior) {
        warrior.setHealth(warrior.getHealth() + getHealing());
        if (warrior.getHealth() > warrior.getMaxHealth()) {
            warrior.setHealth(warrior.getMaxHealth());
        }
    }

    @Override
    void equipWeapon(Weapon weapon) {
        this.setHealth(getHealth() + weapon.getHealth());
        this.setMaxHealth(this.getHealth());
        setHealing(getHealing() + weapon.getHealing());
        if (getHealing() < 0) {
            setHealing(0);
        }
    }

    void setHealing(int healing) {
        this.healing = healing;
    }

    int getHealing() {
        return this.healing;
    }

}
