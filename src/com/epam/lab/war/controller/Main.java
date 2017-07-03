package com.epam.lab.war.controller;

import com.epam.lab.war.model.droid.BattleDroidB1;
import com.epam.lab.war.model.droid.SuperBattleDroidB2;
import com.epam.lab.war.model.weapon.BlusterGun;
import com.epam.lab.war.model.weapon.RocketGun;

import java.util.Scanner;

/**
 * Created by Mykola on 29.06.2017.
 */
public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        GameController gameController = new GameController();
        CreateBattleField.setUpBattleField();
        gameController.startGame();
        gameController.battleRound();

    }

}
