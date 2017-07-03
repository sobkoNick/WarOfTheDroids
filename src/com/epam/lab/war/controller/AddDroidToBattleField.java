package com.epam.lab.war.controller;

import java.util.List;

/**
 * Created by Mykola on 03.07.2017.
 */
public class AddDroidToBattleField {
    public static void addDroidDekaToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = 'D';
    }
    public static void addB1ToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = 'B';
    }
    public static void addSuperB2ToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = 'S';
    }
    public static void addEnergyDroidToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = 'E';
    }
    public static void addMechanicDroidToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = 'M';
    }
}
