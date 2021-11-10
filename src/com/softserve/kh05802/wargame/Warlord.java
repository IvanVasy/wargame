package com.softserve.kh05802.wargame;

public class Warlord extends Warrior {

    private int defense = 2;

    public Warlord() {
        this(5, 100, 2);
    }

    protected Warlord(int attack, int health, int defense) {
        super(attack, health);
        this.defense = defense;
    }

    @Override
    void equipWeapon(Weapon weapon) {
        super.equipWeapon(weapon);
        defense += weapon.getDefense();
        if (defense < 0) {
            defense = 0;
        }
    }

    @Override
    protected int getDamage(Warrior damageDealer) {
        int damage = damageDealer.getAttack() - defense;
        return Math.max(damage, 0);
    }
}
