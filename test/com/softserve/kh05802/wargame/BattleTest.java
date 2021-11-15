package com.softserve.kh05802.wargame;


import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class BattleTest {

    @Test
    @Order(1)
    @DisplayName("1. Fight")
    void fight1() {
        // arrange
        Warrior carl = new Warrior();
        Warrior jim = new Knight();

        // act
        boolean result = Battle.fight(carl, jim);

        // assert
        assertFalse(result);
    }

    @Test
    @Order(2)
    @DisplayName("2. Fight")
    void fight2() {
        Warrior ramon = new Knight();
        Warrior slevin = new Warrior();

        boolean result = Battle.fight(ramon, slevin);

        assertTrue(result);
    }

    @Test
    @Order(3)
    @DisplayName("3. Fight")
    void fight3() {
        Warrior bob = new Warrior();
        Warrior mars = new Warrior();

        Battle.fight(bob, mars);

        assertTrue(bob.isAlive());
    }

    @Test
    @Order(4)
    @DisplayName("4. Fight")
    void fight4() {
        Warrior zeus = new Knight();
        Warrior godKiller = new Warrior();

        Battle.fight(zeus, godKiller);

        assertTrue(zeus.isAlive());
    }

    @Test
    @Order(5)
    @DisplayName("5. Fight")
    void fight5() {
        Warrior husband = new Warrior();
        Warrior wife = new Warrior();

        Battle.fight(husband, wife);

        assertFalse(wife.isAlive());
    }

    @Test
    @Order(6)
    @DisplayName("6. Fight")
    void fight6() {
        Warrior dragon = new Warrior();
        Warrior knight = new Knight();

        Battle.fight(dragon, knight);

        assertTrue(knight.isAlive());
    }

    @Test
    @Order(7)
    @DisplayName("7. Fight")
    void fight7() {
        Warrior unit1 = new Warrior();
        Warrior unit2 = new Knight();
        Warrior unit3 = new Warrior();

        Battle.fight(unit1, unit2);
        boolean result = Battle.fight(unit2, unit3);

        assertFalse(result);
    }

    @Test
    @Order(8)
    @DisplayName("8. Fight")
    void fight8() {
        Warrior unit1 = new Defender();
        Warrior unit2 = new Rookie();

        Battle.fight(unit1, unit2);

        assertEquals(60, unit1.getHealth());
    }

    @Test
    @Order(9)
    @DisplayName("9. Fight")
    void fight9() {
        Warrior unit1 = new Defender();
        Warrior unit2 = new Rookie();
        Warrior unit3 = new Warrior();

        Battle.fight(unit1, unit2);
        boolean result = Battle.fight(unit1, unit3);

        assertTrue(result);
    }

    @Test
    @DisplayName("10. Fight (Dracula)")
    void fight10() {
        Warrior unit1 = new Dracula();
        Warrior unit2 = new Rookie();
        Warrior unit3 = new Warrior();

        Battle.fight(unit1, unit2);
        boolean result = Battle.fight(unit1, unit3);

        assertTrue(result);
    }

    @Test
    @DisplayName("11. Fight (Dracula)")
    void fight11() {
        Warrior unit1 = new Dracula();
        Warrior unit3 = new Warrior();
        unit3.equipWeapon(Weapon.katana());
        boolean result = Battle.fight(unit1, unit3);
        assertTrue(result);
    }

    @Test
    @DisplayName("12. Fight (HighVampire vs Werewolf)")
    void fight12() {
        Warrior unit1 = new HighVampire();
        Warrior unit3 = new Werewolf();
        boolean result = Battle.fight(unit1, unit3);
        assertTrue(result);
    }

    @Test
    @DisplayName("13. Fight (HighVampire vs Ghosy)")
    void fight13() {
        Warrior unit1 = new Ghost();
        Warrior unit3 = new HighVampire();
        boolean result = Battle.fight(unit1, unit3);
        assertFalse(result);
    }

    @Test
    @DisplayName("14. Fight (1hp Warrior vs Ghost)")
    void fight14() {
        var weapon = new Weapon.WeaponBuilder()
                .weaponWithHealth(-46)
                .weaponWithAttack(54)
                .weaponWithDefense(1_000_000)
                .weaponWithVampirism(200)
                .weaponWithHealing(+1000)
                .build();
        Warrior unit1 = new Ghost();
        Warrior unit3 = new Warrior();
        unit3.equipWeapon(weapon);
        boolean result = Battle.fight(unit1, unit3);
        assertTrue(result);
    }

    @Test
    @DisplayName("15. Fight (no weapon on evolve units)")
    void fight15() {
        Warrior unit1 = new Ghost();
        unit1.equipWeapon(Weapon.katana());
        unit1.equipWeapon(Weapon.katana());
        unit1.equipWeapon(Weapon.katana());
        unit1.equipWeapon(Weapon.katana());
        unit1.equipWeapon(Weapon.katana());
        Warrior unit2 = new Vampire();
        boolean result = Battle.fight(unit1, unit2);
        assertFalse(result);
    }

    @Test
    @Order(10)
    @DisplayName("1. Battle")
    void battle1() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 1);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 2);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @Order(11)
    @DisplayName("2. Battle")
    void battle2() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 2);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 3);
        boolean res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @Order(12)
    @DisplayName("3. Battle")
    void battle3() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 5);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 7);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @Order(13)
    @DisplayName("4. Battle")
    void battle4() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 20);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 21);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @Order(14)
    @DisplayName("5. Battle")
    void battle5() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 10);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 11);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @Order(15)
    @DisplayName("6. Battle")
    void battle6() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 11);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 7);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @Order(16)
    @DisplayName("7. Battle")
    void battle7() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 5)
                .addUnits(Defender.class, 4)
                .addUnits(Defender.class, 5);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 4);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @Order(17)
    @DisplayName("8. Battle")
    void battle8() {
        Army army1 = new Army();
        army1.addUnits(Defender.class, 5)
                .addUnits(Warrior.class, 20);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 21)
                .addUnits(Defender.class, 4);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @Order(18)
    @DisplayName("9. Battle")
    void battle9() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 10)
                .addUnits(Defender.class, 5);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 5);
        army1.addUnits(Defender.class, 10);

        boolean res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @Order(19)
    @DisplayName("10. Battle")
    void battle10() {
        Army army1 = new Army();
        army1.addUnits(Defender.class, 2)
                .addUnits(Warrior.class, 1)
                .addUnits(Defender.class, 1);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 5);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @Order(20)
    @DisplayName("11. Battle")
    void battle11() {
        Army army1 = new Army();
        army1.addUnits(Defender.class, 5)
                .addUnits(Vampire.class, 6)
                .addUnits(Warrior.class, 7);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 6)
                .addUnits(Defender.class, 6)
                .addUnits(Vampire.class, 6);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @Order(21)
    @DisplayName("12. Battle")
    void battle12() {
        Army army1 = new Army();
        army1.addUnits(Defender.class, 2)
                .addUnits(Vampire.class, 3)
                .addUnits(Warrior.class, 4);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 4)
                .addUnits(Vampire.class, 3);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @Order(22)
    @DisplayName("13. Battle")
    void battle13() {
        Army army1 = new Army();
        army1.addUnits(Defender.class, 11)
                .addUnits(Vampire.class, 3)
                .addUnits(Warrior.class, 4);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 4)
                .addUnits(Vampire.class, 13);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @Order(23)
    @DisplayName("14. Battle")
    void battle14() {
        Army army1 = new Army();
        army1.addUnits(Defender.class, 9)
                .addUnits(Vampire.class, 3)
                .addUnits(Warrior.class, 8);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 4)
                .addUnits(Vampire.class, 13);

        boolean res = Battle.fight(army1, army2);

        assertTrue(res);
    }

    @Test
    @Order(24)
    @DisplayName("15. Battle")
    void battle15() {
        Army army1 = new Army().addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 2)
                .addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 4)
                .addUnits(Vampire.class, 6);
        Army army2 = new Army().addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 4)
                .addUnits(Vampire.class, 6)
                .addUnits(Lancer.class, 5);

        boolean res = Battle.fight(army1, army2);

        assertFalse(res);
    }

    @Test
    @Order(25)
    @DisplayName("16. Battle")
    void battle16() {
        Army army1 = new Army().addUnits(Lancer.class, 7)
                .addUnits(Vampire.class, 3)
                .addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 2);
        Army army2 = new Army().addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 4)
                .addUnits(Vampire.class, 6)
                .addUnits(Lancer.class, 4);

        boolean res = Battle.fight(army1, army2);
        assertTrue(res);

    }

    @Test
    @Order(25)
    @DisplayName("Lancer")
    void lancer() {
        Warrior chuck = new Warrior();
        Warrior bruce = new Warrior();
        Warrior carl = new Knight();
        Warrior dave = new Warrior();
        Warrior mark = new Warrior();
        Warrior bob = new Defender();
        Warrior mike = new Knight();
        Warrior rog = new Warrior();
        Warrior lancelot = new Defender();
        Warrior eric = new Vampire();
        Warrior adam = new Vampire();
        Warrior richard = new Defender();
        Warrior ogre = new Warrior();
        Warrior freelancer = new Lancer();
        Warrior vampire = new Vampire();

        assertTrue(Battle.fight(chuck, bruce));
        assertFalse(Battle.fight(dave, carl));
        assertTrue(chuck.isAlive());
        assertFalse(bruce.isAlive());
        assertTrue(carl.isAlive());
        assertFalse(dave.isAlive());

        assertFalse(Battle.fight(carl, mark));
        assertFalse(carl.isAlive());

        assertFalse(Battle.fight(bob, mike));
        assertTrue(Battle.fight(lancelot, rog));
        assertFalse(Battle.fight(eric, richard));
        assertTrue(Battle.fight(ogre, adam));
        assertTrue(Battle.fight(freelancer, vampire));
        assertTrue(freelancer.isAlive());

        Army myArmy = new Army();
        myArmy.addUnits(Defender.class, 2)
                .addUnits(Vampire.class, 2)
                .addUnits(Lancer.class, 4)
                .addUnits(Warrior.class, 1);

        Army enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 2)
                .addUnits(Lancer.class, 2)
                .addUnits(Defender.class, 2)
                .addUnits(Vampire.class, 3);

        Army army3 = new Army();
        army3.addUnits(Warrior.class, 1)
                .addUnits(Lancer.class, 1)
                .addUnits(Defender.class, 2);

        Army army4 = new Army();
        army4.addUnits(Vampire.class, 3)
                .addUnits(Warrior.class, 1)
                .addUnits(Lancer.class, 2);

        assertTrue(Battle.fight(myArmy, enemyArmy));
        assertFalse(Battle.fight(army3, army4));
    }

    @Test
    @Order(26)
    @DisplayName("Healer")
    void heal() {
        Army army1 = new Army();
        Army army2 = new Army();
        army1.addUnits(Lancer.class, 1);
        army2.addUnits(Knight.class, 1);
        army2.addUnits(Healer.class, 1);
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("19. Battle")
    void battle19() {
        Army army1 = new Army();
        army1.addUnits(Lancer.class, 5);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Defender.class, 2);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 5);
        var res = Battle.straightFight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("20. Battle")
    void battle20() {
        Army army1 = new Army();
        army1.addUnits(Lancer.class, 7);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Defender.class, 2);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 4);
        var res = Battle.straightFight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("21. Battle")
    void battle21() {
        Army army1 = new Army();
        army1.addUnits(Lancer.class, 7);
        army1.addUnits(Vampire.class, 3);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Defender.class, 2);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army2.addUnits(Healer.class, 1);
        army2.addUnits(Vampire.class, 6);
        army2.addUnits(Lancer.class, 4);
        var res = Battle.straightFight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("22. Battle")
    void battle22() {
        Army army1 = new Army();
        army1.addUnits(Lancer.class, 4);
        army1.addUnits(Warrior.class, 3);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Warrior.class, 4);
        army1.addUnits(Healer.class, 1);
        army1.addUnits(Knight.class, 2);
        Army army2 = new Army();
        army2.addUnits(Warrior.class, 4);
        army2.addUnits(Defender.class, 4);
        army1.addUnits(Healer.class, 1);
        army2.addUnits(Vampire.class, 2);
        army2.addUnits(Lancer.class, 4);
        var res = Battle.straightFight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("23. Battle")
    void battle23() {
        Army army1 = new Army();
        army1.addUnits(Warlord.class, 1);
        army1.addUnits(Warrior.class, 2);
        army1.addUnits(Lancer.class, 2);
        army1.addUnits(Healer.class, 2);
        Army army2 = new Army();
        army2.addUnits(Warlord.class, 1);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Healer.class, 2);
        army2.addUnits(Knight.class, 2);
        army1.moveUnits();
        army2.moveUnits();
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("24. Battle")
    void battle24() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 2);
        army1.addUnits(Lancer.class, 2);
        army1.addUnits(Defender.class, 1);
        army1.addUnits(Warlord.class, 3);
        Army army2 = new Army();
        army2.addUnits(Warlord.class, 2);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Healer.class, 5);
        army2.addUnits(Knight.class, 2);
        army1.moveUnits();
        army2.moveUnits();
        var res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("25. Battle")
    void battle25() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 2);
        army1.addUnits(Lancer.class, 3);
        army1.addUnits(Defender.class, 1);
        army1.addUnits(Warlord.class, 4);
        Army army2 = new Army();
        army2.addUnits(Warlord.class, 1);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Rookie.class, 1);
        army2.addUnits(Knight.class, 1);
        army1.peekUnit(0).equipWeapon(Weapon.sword());
        army2.peekUnit(0).equipWeapon(Weapon.shield());
        army1.moveUnits();
        army2.moveUnits();
        var res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("26. Battle")
    void battle26() {
        Army army1 = new Army();
        army1.addUnits(Warrior.class, 2);
        army1.addUnits(Lancer.class, 3);
        army1.addUnits(Defender.class, 1);
        army1.addUnits(Warlord.class, 1);
        Army army2 = new Army();
        army2.addUnits(Warlord.class, 5);
        army2.addUnits(Vampire.class, 1);
        army2.addUnits(Rookie.class, 1);
        army2.addUnits(Knight.class, 1);
        army1.peekUnit(0).equipWeapon(Weapon.sword());
        army2.peekUnit(0).equipWeapon(Weapon.shield());
        army1.moveUnits();
        army2.moveUnits();
        var res = Battle.straightFight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("27. Battle")
    void battle27() {
        Army army1 = new Army().addUnits(Lancer.class, 7).addUnits(Dracula.class, 1_000)
                .addUnits(Vampire.class, 3)
                .addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 2);
        Army army2 = new Army().addUnits(Lancer.class, 2).addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 4)
                .addUnits(Vampire.class, 6)
                .addUnits(Lancer.class, 4);
        army1.moveUnits();
        army2.moveUnits();
        boolean res = Battle.fight(army1, army2);
        assertTrue(res);
    }

    @Test
    @DisplayName("28. Battle")
    void battle28() {
        Army army1 = new Army().addUnits(Lancer.class, 7).addUnits(Dracula.class, 1_000)
                .addUnits(Vampire.class, 3)
                .addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 2);
        Army army2 = new Army().addUnits(Lancer.class, 7).addUnits(Dracula.class, 1_000)
                .addUnits(Vampire.class, 3)
                .addUnits(Warrior.class, 4)
                .addUnits(Defender.class, 6);
        army1.moveUnits();
        army2.moveUnits();
        boolean res = Battle.fight(army1, army2);
        assertFalse(res);
    }

    @Test
    @DisplayName("1. Weapon")
    void weapon1() {
        var unit1 = new Warrior();
        var unit2 = new Vampire();
        var weapon1 = new Weapon.WeaponBuilder()
                .weaponWithHealth(-10)
                .weaponWithAttack(5)
                .weaponWithVampirism(40)
                .build();
        var weapon2 = Weapon.sword();
        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);
        var res = Battle.fight(unit1, unit2);
        assertTrue(res);
    }

    @Test
    @DisplayName("2. Weapon")
    void weapon2() {
        var unit1 = new Defender();
        var unit2 = new Lancer();
        var weapon1 = Weapon.shield();
        var weapon2 = Weapon.greateAxe();
        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);
        var res = Battle.fight(unit1, unit2);
        assertFalse(res);
    }

    @Test
    @DisplayName("3. Weapon")
    void weapon3() {
        var unit1 = new Healer();
        var unit2 = new Knight();
        var weapon1 = Weapon.magicWand();
        var weapon2 = Weapon.katana();
        unit1.equipWeapon(weapon1);
        unit2.equipWeapon(weapon2);
        var res = Battle.fight(unit1, unit2);
        assertFalse(res);
    }

    @Test
    @DisplayName("4. Weapon")
    void weapon4() {
        var unit1 = new Defender();
        var unit2 = new Vampire();
        var weapon1 = Weapon.shield();
        var weapon2 = Weapon.magicWand();
        var weapon3 = Weapon.shield();
        var weapon4 = Weapon.katana();
        unit1.equipWeapon(weapon1);
        unit1.equipWeapon(weapon2);
        unit2.equipWeapon(weapon3);
        unit2.equipWeapon(weapon4);
        var res = Battle.fight(unit1, unit2);
        assertFalse(res);
    }

    @Test
    @DisplayName("5. Weapon")
    void weapon5() {
        var weapon1 = Weapon.magicWand();
        var weapon2 = Weapon.greateAxe();
        var myArmy = new Army();
        myArmy.addUnits(Knight.class, 1);
        myArmy.addUnits(Lancer.class, 1);
        var enemyArmy = new Army();
        enemyArmy.addUnits(Vampire.class, 1);
        enemyArmy.addUnits(Healer.class, 1);
        myArmy.peekUnit(0).equipWeapon(weapon1);
        myArmy.peekUnit(1).equipWeapon(weapon2);
        enemyArmy.peekUnit(0).equipWeapon(weapon1);
        enemyArmy.peekUnit(1).equipWeapon(weapon2);
        var res = Battle.fight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("6. Weapon")
    void weapon6() {
        var weapon1 = Weapon.sword();
        var weapon2 = Weapon.greateAxe();
        var myArmy = new Army();
        myArmy.addUnits(Defender.class, 1);
        myArmy.addUnits(Warrior.class, 1);
        var enemyArmy = new Army();
        enemyArmy.addUnits(Knight.class, 1);
        enemyArmy.addUnits(Healer.class, 1);
        myArmy.peekUnit(0).equipWeapon(weapon2);
        myArmy.peekUnit(1).equipWeapon(weapon2);
        enemyArmy.peekUnit(0).equipWeapon(weapon1);
        enemyArmy.peekUnit(1).equipWeapon(weapon1);
        var res = Battle.fight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("7. Weapon")
    void weapon7() {
        var weapon1 = Weapon.katana();
        var myArmy = new Army();
        myArmy.addUnits(Defender.class, 2);
        var enemyArmy = new Army();
        enemyArmy.addUnits(Knight.class, 1);
        enemyArmy.addUnits(Vampire.class, 1);
        myArmy.peekUnit(0).equipWeapon(weapon1);
        myArmy.peekUnit(1).equipWeapon(weapon1);
        enemyArmy.peekUnit(0).equipWeapon(weapon1);
        enemyArmy.peekUnit(1).equipWeapon(weapon1);
        var res = Battle.fight(myArmy, enemyArmy);
        assertFalse(res);
    }

    @Test
    @DisplayName("8. Weapon")
    void weapon8() {
        var weapon1 = new Weapon.WeaponBuilder()
                .weaponWithHealing(-20)
                .weaponWithAttack(6)
                .weaponWithDefense(1)
                .weaponWithVampirism(40)
                .weaponWithHealing(-2)
                .build();
        var weapon2 = new Weapon.WeaponBuilder()
                .weaponWithHealing(20)
                .weaponWithAttack(-2)
                .weaponWithDefense(2)
                .weaponWithVampirism(-55)
                .weaponWithHealing(3)
                .build();
        var myArmy = new Army();
        myArmy.addUnits(Knight.class, 3);
        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 1);
        enemyArmy.addUnits(Defender.class, 2);
        myArmy.peekUnit(0).equipWeapon(weapon1);
        myArmy.peekUnit(1).equipWeapon(weapon1);
        myArmy.peekUnit(2).equipWeapon(weapon2);
        enemyArmy.peekUnit(0).equipWeapon(weapon1);
        enemyArmy.peekUnit(1).equipWeapon(weapon2);
        enemyArmy.peekUnit(2).equipWeapon(weapon2);
        var res = Battle.fight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("9. Weapon")
    void weapon9() {
        var weapon1 = new Weapon.WeaponBuilder()
                .weaponWithHealth(-20)
                .weaponWithAttack(1)
                .weaponWithDefense(1)
                .weaponWithVampirism(40)
                .weaponWithHealing(-2)
                .build();
        var weapon2 = new Weapon.WeaponBuilder()
                .weaponWithHealth(20)
                .weaponWithAttack(2)
                .weaponWithDefense(2)
                .weaponWithVampirism(-55)
                .weaponWithHealing(3)
                .build();
        var myArmy = new Army();
        myArmy.addUnits(Vampire.class, 3);
        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 1);
        enemyArmy.addUnits(Defender.class, 2);
        myArmy.peekUnit(0).equipWeapon(weapon1);
        myArmy.peekUnit(1).equipWeapon(weapon1);
        myArmy.peekUnit(2).equipWeapon(weapon2);
        enemyArmy.peekUnit(0).equipWeapon(weapon1);
        enemyArmy.peekUnit(1).equipWeapon(weapon2);
        enemyArmy.peekUnit(2).equipWeapon(weapon2);
        var res = Battle.fight(myArmy, enemyArmy);
        assertFalse(res);
    }

    @Test
    @DisplayName("10. Weapon")
    void weapon10() {
        var weapon1 = Weapon.katana();
        var weapon2 = Weapon.shield();
        var myArmy = new Army();
        myArmy.addUnits(Vampire.class, 2);
        myArmy.addUnits(Rookie.class, 2);
        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 1);
        enemyArmy.addUnits(Defender.class, 2);
        myArmy.peekUnit(0).equipWeapon(weapon1);
        myArmy.peekUnit(1).equipWeapon(weapon1);
        myArmy.peekUnit(2).equipWeapon(weapon2);
        enemyArmy.peekUnit(0).equipWeapon(weapon1);
        enemyArmy.peekUnit(1).equipWeapon(weapon2);
        enemyArmy.peekUnit(2).equipWeapon(weapon2);
        var res = Battle.straightFight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("11. Weapon")
    void weapon11() {
        var weapon1 = Weapon.sword();
        var weapon2 = Weapon.greateAxe();
        var myArmy = new Army();
        myArmy.addUnits(Vampire.class, 3);
        var enemyArmy = new Army();
        enemyArmy.addUnits(Warrior.class, 1);
        enemyArmy.addUnits(Defender.class, 1);
        myArmy.peekUnit(0).equipWeapon(weapon2);
        myArmy.peekUnit(1).equipWeapon(weapon2);
        myArmy.peekUnit(2).equipWeapon(weapon2);
        enemyArmy.peekUnit(0).equipWeapon(weapon1);
        enemyArmy.peekUnit(1).equipWeapon(weapon1);
        var res = Battle.straightFight(myArmy, enemyArmy);
        assertTrue(res);
    }

    @Test
    @DisplayName("12. Weapon")
    void weapon12() {
        var weapon1 = Weapon.katana();
        var weapon2 = Weapon.magicWand();
        var myArmy = new Army();
        myArmy.addUnits(Rookie.class, 3);
        var enemyArmy = new Army();
        enemyArmy.addUnits(Defender.class, 1);
        enemyArmy.addUnits(Healer.class, 1);
        myArmy.peekUnit(0).equipWeapon(weapon1);
        myArmy.peekUnit(1).equipWeapon(weapon1);
        myArmy.peekUnit(2).equipWeapon(weapon1);
        enemyArmy.peekUnit(0).equipWeapon(weapon2);
        enemyArmy.peekUnit(1).equipWeapon(weapon2);
        var res = Battle.straightFight(myArmy, enemyArmy);
        assertFalse(res);
    }
}
