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

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        GameController gameController = new GameController();
        gameController.setUpBattleField();
        gameController.startGame();


        for (int i = 0; i < 10; i++) {
            gameController.battleRound();
        }


//        System.out.println("hello");
//        try {
//            Thread.sleep(1000); // Just to give the user a chance to see "hello".
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
////        System.out.print("\b\b\b\b\b");
//        System.out.print("world");
    }

}
