package com.softserve.kh05802.wargame;

public class Warrior {
    private int health;
    private int attack;
    private int maxHealth;
    private Warrior behind;
    private boolean fightMode = true; //true - fight from a lot of duels; false - wall vs wall


    public Warrior() {
        this(5, 50);
    }

    protected Warrior(int attack, int health) {
        this.attack = attack;
        this.health = health;
        maxHealth = health;
    }

    void equipWeapon(Weapon weapon) {
        if (!isAlive() || weapon == null) {
            return;
        }
        health += weapon.getHealth();
        maxHealth = health;
        attack += weapon.getAttack();
        if (attack < 0)
            attack = 0;
    }

    void hits(Warrior damageTaker) {
        damageTaker.setHealth(damageTaker.getHealth() - damageTaker.getDamage(this));
        if (getFightMode()) {
            if (!(getBehind() instanceof Healer)) {
                return;
            }
            ((Healer) getBehind()).heal(this);
        }
    }

    protected int getDamage(Warrior damageDealer) {
        return damageDealer.getAttack();
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + '{' +
                "health=" + health +
                ", attack=" + attack +
                '}';
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

    void setFightMode(boolean fightMode) {
        this.fightMode = fightMode;
    }

    protected void setBehind(Warrior behind) {
        this.behind = behind;
    }

    protected Warrior getBehind() {
        return behind;
    }

}
