package com.epam.lab.war.controller;

import com.epam.lab.war.model.droid.*;
import com.epam.lab.war.model.weapon.BlusterGun;
import com.epam.lab.war.model.weapon.RocketGun;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by Mykola on 03.07.2017.
 */
public class CreateDroid {

    private List<Integer> droidPositionList = new LinkedList<>();

    public List<Integer> generatePosition(boolean enemy) {
        Random random = new Random();

        int positionX;
        int positionY;

        if (enemy) {
            positionX = random.nextInt(11);
            positionY = random.nextInt(4);
        } else {
            positionX = random.nextInt(11);
            positionY = ThreadLocalRandom.current().nextInt(8, 11 + 1);
        }

        List<Integer> positionList = new LinkedList<>();

        if (GameController.battleField[positionY][positionX] == '0' ||
                GameController.battleField[positionY][positionX] == '1' ||
                GameController.battleField[positionY][positionX] == '2') {
            positionList.add(positionX);
            positionList.add(positionY);
            return positionList;
        }
        return generatePosition(enemy);
    }

    public Droideka createDekaDroid(boolean enemy) {
        droidPositionList = generatePosition(enemy);
        Droideka droideka = new Droideka(100, 100, droidPositionList.get(0), droidPositionList.get(1),
                new BlusterGun(), new BlusterGun(), new BlusterGun(), new BlusterGun(), 100, false);
        AddDroidToBattleField.addDroidDekaToBattleField(droidPositionList);
        return droideka;
    }

    public BattleDroidB1 createBattleDroidB1(boolean enemy) {
        droidPositionList = generatePosition(enemy);
        BattleDroidB1 b1 = new BattleDroidB1(100, 100, droidPositionList.get(0), droidPositionList.get(1), new BlusterGun());
        AddDroidToBattleField.addB1ToBattleField(droidPositionList);
        return b1;
    }

    public SuperBattleDroidB2 createSuperB2(boolean enemy) {
        droidPositionList = generatePosition(enemy);
        SuperBattleDroidB2 b2 = new SuperBattleDroidB2(100, 100, droidPositionList.get(0), droidPositionList.get(1), new BlusterGun(), new RocketGun());
        AddDroidToBattleField.addSuperB2ToBattleField(droidPositionList);
        return b2;
    }

    public MechanicDroid createMechanicDroid(boolean enemy) {
        droidPositionList = generatePosition(enemy);
        MechanicDroid mechanicDroid = new MechanicDroid(100, 100, droidPositionList.get(0), droidPositionList.get(1));
        AddDroidToBattleField.addMechanicDroidToBattleField(droidPositionList);
        return mechanicDroid;
    }

    public EnergyDroid createEnergyDroid(boolean enemy) {
        droidPositionList = generatePosition(enemy);
        EnergyDroid energyDroid = new EnergyDroid(100, 100, droidPositionList.get(0), droidPositionList.get(1));
        AddDroidToBattleField.addEnergyDroidToBattleField(droidPositionList);
        return energyDroid;
    }
}
