package com.softserve.kh05802.wargame;

import java.util.LinkedList;
import java.util.List;


public class Army {

    private boolean haveWarlord = false;
    private LinkedList<Warrior> preparedArmy = new LinkedList<>();


    boolean armyIsAlive() {
        boolean hisAlive = true;
        for (Warrior warrior : preparedArmy) {
            hisAlive = warrior.isAlive();
        }
        return !preparedArmy.isEmpty() && hisAlive;
    }

    public Warrior peekUnit(int i) {
        return preparedArmy.get(i);
    }

    void clearArmy() {
        preparedArmy.removeIf(warrior -> !warrior.isAlive());
    }

    void fightModeSetStraight(boolean mode) {
        for (Warrior warrior : preparedArmy) {
            warrior.setFightMode(mode);
        }
    }

    Army addUnits(Class<? extends Warrior> type, int quantity) {
        List<Warrior> list = generateUnits(type, quantity);
        for (Warrior warrior : list) {
            if (!preparedArmy.isEmpty()) {
                preparedArmy.getLast().setBehind(warrior);
            }
            preparedArmy.add(warrior);
        }
        return this;
    }

    protected void reconnect() {
        if (preparedArmy.size() == 1) {
            return;
        }
        for (int i = 0; i < preparedArmy.size() - 1; i++) {
            preparedArmy.get(i).setBehind(preparedArmy.get(i + 1));
        }
    }

    private List<Warrior> generateUnits(Class<? extends Warrior> type, int quantity) {
        List<Warrior> res = new LinkedList<>();
        if (type == Warlord.class) {
            if (!haveWarlord) {
                res.add(generateUnit(type));
                haveWarlord = true;
            }
        } else {
            for (int i = 0; i < quantity; i++) {
                res.add(generateUnit(type));
            }
        }
        return res;
    }

    private Warrior generateUnit(Class<? extends Warrior> type) {
        return generateUnit(type.getSimpleName());
    }

    private Warrior generateUnit(String type) {
        return switch (type) {
            case "Warrior" -> new Warrior();
            case "Knight" -> new Knight();
            case "Defender" -> new Defender();
            case "Vampire" -> new Vampire();
            case "Lancer" -> new Lancer();
            case "Healer" -> new Healer();
            case "Warlord" -> new Warlord();
            case "Rookie" -> new Rookie();
            default -> throw new IllegalArgumentException("Unknown type: " + type);
        };
    }

    boolean checkFor(int i, Class<? extends Warrior> type) {
        return preparedArmy.get(i).getClass() == type;
    }

    void swap(int i, int j) {
        preparedArmy.set(i, preparedArmy.set(j, preparedArmy.get(i)));
    }

    protected void moveUnits() {
        if (!haveWarlord)
            return;
        for (int i = 0; i < preparedArmy.size(); i++)
            for (int j = i + 1; j < preparedArmy.size(); j++) {
                if (!checkFor(i, Lancer.class) && checkFor(j, Lancer.class))
                    swap(i, j);
                if (checkFor(i, Warlord.class))
                    swap(i, preparedArmy.size() - 1);
                if (!checkFor(0, Lancer.class) && !checkFor(j, Healer.class) && !checkFor(j, Warlord.class))
                    swap(0, j);
                if (i != 0 && !checkFor(i, Healer.class) && checkFor(j, Healer.class))
                    swap(i, j);
            }
    }

    public int getFirst() {
        return 0;
    }

    public List<Warrior> getPreparedArmy() {
        return preparedArmy;
    }

}