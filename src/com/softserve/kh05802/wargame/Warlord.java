package com.softserve.kh05802.wargame;

public class Warlord extends Warrior {

    private int defense;

    public Warlord() {
        this(4, 100, 2);
    }

    protected Warlord(int attack, int health, int defense) {
        super(attack, health);
        this.defense = defense;
    }

    @Override
    void equipWeapon(Weapon weapon) {
       this.setAttack(this.getAttack()+ weapon.getAttack());
        if (getAttack() < 0)
            setAttack(0);
        setMaxHealth(getMaxHealth()+ weapon.getHealth());
        setHealth(getMaxHealth());
        if (getHealth() < 0)
            setHealth(0);
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
