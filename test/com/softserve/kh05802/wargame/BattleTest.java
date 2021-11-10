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
}