package com.softserve.kh05802.wargame;

public class Vampire extends Warrior {
    private int vampirism = 50;// percents


    public Vampire() {
        this(4, 40, 50);
    }

    protected Vampire(int attack, int health, int vampirism) {
        super(attack, health);
        this.setMaxHealth(this.getHealth());
        this.vampirism = vampirism;
    }

    @Override
    void hits(Warrior damageTaker) {
        int startHealth = damageTaker.getHealth();
        super.hits(damageTaker);
        int damage = startHealth - damageTaker.getHealth();
        this.setHealth(this.getHealth() + (damage * vampirism / 100));
        if (this.getHealth() > this.getMaxHealth()) {
            this.setHealth(this.getMaxHealth());
        }
    }

    @Override
    void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        vampirism += weapon.getVampirism();
        if (vampirism < 0) {
            vampirism = 0;
        }

    }
}
