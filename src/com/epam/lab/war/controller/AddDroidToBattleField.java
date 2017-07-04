package com.epam.lab.war.controller;

import com.epam.lab.war.model.droid.constant.DroidContant;

import java.util.List;

/**
 * Add Droids to battleField
 */
public class AddDroidToBattleField {
    public static void addDroidDekaToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = DroidContant.DROID_DEKA_SYMBOL;
    }
    public static void addB1ToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = DroidContant.B1_SYMBOL;
    }
    public static void addSuperB2ToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = DroidContant.B2_SYMBOL;
    }
    public static void addEnergyDroidToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = DroidContant.ENERGY_SYMBOL;
    }
    public static void addMechanicDroidToBattleField(List<Integer> position) {
        GameController.battleField[position.get(1)][position.get(0)] = DroidContant.MECHANIC_SYMBOL;
    }
}
