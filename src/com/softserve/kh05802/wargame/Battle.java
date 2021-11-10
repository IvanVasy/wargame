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
        while (army1.armyIsAlive() && army2.armyIsAlive()) {
            for (int counter = 0; counter < Math.min(attacker.size(), defender.size()); counter++) {
                fight(attacker.get(counter), defender.get(counter));

            }
            army1.clearArmy();
            army2.clearArmy();
        }
        return army1.armyIsAlive();
    }

    public static boolean fight(Army army1, Army army2) {
        List<Warrior> attacker = army1.getPreparedArmy();
        army1.fightModeSetStraight(true);
        List<Warrior> defender = army2.getPreparedArmy();
        army1.fightModeSetStraight(true);
        while (army1.armyIsAlive() && army2.armyIsAlive()) {
            if (fight(attacker.get(army1.getCounter()), defender.get(army2.getCounter()))) {
                army2.clearArmy();
                army2.moveUnits();
                army2.rebuild();
            } else {
                army1.clearArmy();
                army1.moveUnits();
                army1.rebuild();
            }
        }
        return army1.armyIsAlive();
    }
}
