package com.softserve.kh05802.wargame;

public class Lancer extends Warrior {
    private int damageDrop = 50;

    public Lancer() {
        this(6, 50, 50);
    }

    protected Lancer(int attack, int health, int damageDrop) {
        super(attack, health);
        this.setMaxHealth(this.getHealth());
        this.damageDrop = damageDrop;
    }

    @Override
    void hits(Warrior damageTaker) {
        int firstDealDamage = damageTaker.getDamage(this);
        damageTaker.setHealth(damageTaker.getHealth() - firstDealDamage);
        if (getFightMode()) {
            Warrior behind = damageTaker.getBehind();
            if (behind != null) {
                behind.setHealth(behind.getHealth() - behind.getDamage(this.new Proxy(firstDealDamage)));
            }
        }
    }

    private class Proxy extends Warrior {
        int baseDamage;

        public Proxy(int baseDamage) {
            this.baseDamage = baseDamage;
        }

        @Override
        int getAttack() {
            return baseDamage * getDamageDrop() / 100;
        }
    }

    protected int getDamageDrop() {
        return this.damageDrop;
    }
}
