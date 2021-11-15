package com.softserve.kh05802.wargame;

import java.util.List;

public class Battle {

    public static boolean fight(Warrior warrior1, Warrior warrior2) {
        while (warrior1.isAlive() && warrior2.isAlive()) {
            warrior1.hits(warrior2);
            if (warrior2.isAlive()) {
                warrior2.hits(warrior1);
            } else {
                return true;
            }
        }
        return warrior1.isAlive();
    }

    public static boolean straightFight(Army army1, Army army2) {
        List<Warrior> attacker = army1.getPreparedArmy();
        army1.fightModeSetStraight(false);
        List<Warrior> defender = army2.getPreparedArmy();
        army2.fightModeSetStraight(false);
        while (army1.isArmyAlive() && army2.isArmyAlive()) {
            for (int counter = 0; counter < Math.min(attacker.size(), defender.size()); counter++) {
                fight(attacker.get(counter), defender.get(counter));
            }
            army1.clearArmy();
            army2.clearArmy();
            army1.moveUnits();
            army2.moveUnits();
        }
        return army1.isArmyAlive();
    }

    public static boolean fight(Army army1, Army army2) {
        List<Warrior> attacker = army1.getPreparedArmy();
        army1.fightModeSetStraight(true);
        army1.reconnect();
        List<Warrior> defender = army2.getPreparedArmy();
        army2.fightModeSetStraight(true);
        army2.reconnect();
        while (army1.isArmyAlive() && army2.isArmyAlive()) {
            if (fight(attacker.get(army1.getFirst()), defender.get(army2.getFirst()))) {
                army2.clearArmy();
                army2.moveUnits();
                army2.reconnect();
            } else {
                army1.clearArmy();
                army1.moveUnits();
                army1.reconnect();
            }

        }
        return army1.isArmyAlive();
    }
}
