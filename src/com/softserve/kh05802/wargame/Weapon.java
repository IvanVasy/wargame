package com.softserve.kh05802.wargame;

public class Weapon {
    private int health;
    private int attack;
    private int defense;
    private int vampirism;
    private int healing;

    static Weapon katana() {
        return new Weapon.WeaponBuilder()
                .WeaponWithHealth(-20)
                .WeaponWithAttack(+6)
                .WeaponWithDefense(-5)
                .WeaponWithVampirism(+50)
                .build();
    }

    static Weapon sword() {
        return new Weapon.WeaponBuilder()
                .WeaponWithHealth(+5)
                .WeaponWithAttack(+2)
                .build();
    }

    static Weapon shield() {
        return new Weapon.WeaponBuilder()
                .WeaponWithHealth(+20)
                .WeaponWithAttack(-1)
                .WeaponWithDefense(+2)
                .build();
    }

    static Weapon greateAxe() {
        return new Weapon.WeaponBuilder()
                .WeaponWithHealth(-15)
                .WeaponWithAttack(+5)
                .WeaponWithDefense(-2)
                .WeaponWithVampirism(+10)
                .build();
    }

    static Weapon magicWand() {
        return new Weapon.WeaponBuilder()
                .WeaponWithHealth(+30)
                .WeaponWithAttack(+3)
                .WeaponWithHealing(+3)
                .build();
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getVampirism() {
        return vampirism;
    }

    public int getHealing() {
        return healing;
    }

    static class WeaponBuilder {
        private Weapon newWeapon;

        WeaponBuilder() {
            newWeapon = new Weapon();
        }

        WeaponBuilder WeaponWithAttack(int attack) {
            newWeapon.attack = attack;
            return this;
        }

        WeaponBuilder WeaponWithHealth(int health) {
            newWeapon.health = health;
            return this;
        }

        WeaponBuilder WeaponWithDefense(int defense) {
            newWeapon.defense = defense;
            return this;
        }

        WeaponBuilder WeaponWithVampirism(int vampirism) {
            newWeapon.vampirism = vampirism;
            return this;
        }

        WeaponBuilder WeaponWithHealing(int healing) {
            newWeapon.healing = healing;
            return this;
        }

        Weapon build() {
            return newWeapon;
        }
    }

}
