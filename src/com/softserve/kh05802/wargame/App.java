package com.softserve.kh05802.wargame;

public class App {
    public static void main(String[] args) {
        Army army = new Army();
        army.addUnits(Warlord.class, 2);
        army.addUnits(Knight.class, 2);
        army.addUnits(Warlord.class, 5);
        for (int i = 0; i < army.getPreparedArmy().size(); i++) {

            System.out.println(army.getPreparedArmy().get(i));
        }
        System.out.println(army.getPreparedArmy().get(2).getBehind());
    }
}
