package com.softserve.kh05802.wargame;

public class Weapon {
    private int health;
    private int attack;
    private int defense;
    private int vampirism;
    private int healing;

    static Weapon katana() {
        return new Weapon.WeaponBuilder()
                .weaponWithHealth(-20)
                .weaponWithAttack(+6)
                .weaponWithDefense(-5)
                .weaponWithVampirism(+50)
                .build();
    }

    static Weapon sword() {
        return new Weapon.WeaponBuilder()
                .weaponWithHealth(+5)
                .weaponWithAttack(+2)
                .build();
    }

    static Weapon shield() {
        return new Weapon.WeaponBuilder()
                .weaponWithHealth(+20)
                .weaponWithAttack(-1)
                .weaponWithDefense(+2)
                .build();
    }

    static Weapon greateAxe() {
        return new Weapon.WeaponBuilder()
                .weaponWithHealth(-15)
                .weaponWithAttack(+5)
                .weaponWithDefense(-2)
                .weaponWithVampirism(+10)
                .build();
    }

    static Weapon magicWand() {
        return new Weapon.WeaponBuilder()
                .weaponWithHealth(+30)
                .weaponWithAttack(+3)
                .weaponWithHealing(+3)
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
        private final Weapon newWeapon;

        WeaponBuilder() {
            newWeapon = new Weapon();
        }

        WeaponBuilder weaponWithAttack(int attack) {
            newWeapon.attack = attack;
            return this;
        }

        WeaponBuilder weaponWithHealth(int health) {
            newWeapon.health = health;
            return this;
        }

        WeaponBuilder weaponWithDefense(int defense) {
            newWeapon.defense = defense;
            return this;
        }

        WeaponBuilder weaponWithVampirism(int vampirism) {
            newWeapon.vampirism = vampirism;
            return this;
        }

        WeaponBuilder weaponWithHealing(int healing) {
            newWeapon.healing = healing;
            return this;
        }

        Weapon build() {
            return newWeapon;
        }
    }

}
