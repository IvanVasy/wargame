package com.softserve.kh05802.wargame;

public class Defender extends Warrior {

    private int defense;

    public Defender() {
        this(3, 60, 2);
    }

    protected Defender(int attack, int health, int defense) {
        super(attack, health);
        this.setMaxHealth(this.getHealth());
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
