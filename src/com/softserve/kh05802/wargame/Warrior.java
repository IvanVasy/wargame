package com.softserve.kh05802.wargame;

public class Warrior {
    private int health = 50;
    private int attack = 5;
    private int maxHealth = health;
    private Warrior behind = null;
    private boolean fightMode = true; //true - fight from a lot of duels; false - wall vs wall


    public Warrior() {
        this(5, 50);
    }

    protected Warrior(int attack, int health) {
        this.attack = attack;
        this.health = health;
    }

    void equipWeapon(Weapon weapon) {
        attack += weapon.getAttack();
        if (attack < 0)
            attack = 0;
        maxHealth += weapon.getHealth();
        health = maxHealth;
        if (health < 0)
            health = 0;
    }

    void hits(Warrior damageTaker) {
        damageTaker.setHealth(damageTaker.getHealth() - damageTaker.getDamage(this));
        if (getFightMode()) {
            if (getBehind() instanceof Healer) {
                ((Healer) getBehind()).heal(this);
            }
        }
    }

    protected int getDamage(Warrior damageDealer) {
        return damageDealer.getAttack();
    }

    void setHealth(int health) {
        this.health = health;
    }

    public boolean isAlive() {
        return health > 0;
    }

    int getMaxHealth() {
        return maxHealth;
    }

    int getHealth() {
        return health;
    }

    int getAttack() {
        return attack;
    }

    void setAttack(int attack) {
        this.attack = attack;
    }

    void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    boolean getFightMode() {
        return fightMode;
    }

    boolean setFightMode(boolean fightMode) {
        return this.fightMode = fightMode;
    }

    protected void setBehind(Warrior behind) {
        this.behind = behind;
    }

    protected Warrior getBehind() {
        return behind;
    }

}
