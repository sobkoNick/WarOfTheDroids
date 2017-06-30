package com.epam.lab.war.controller;

import com.epam.lab.war.model.Droid.BattleDroidB1;
import com.epam.lab.war.model.Droid.Droid;
import com.epam.lab.war.model.Droid.SuperBattleDroidB2;
import com.epam.lab.war.model.Weapon.BlusterGun;
import com.epam.lab.war.model.Weapon.RocketGun;
import com.epam.lab.war.view.ViewStartScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mykola on 29.06.2017.
 */
public class Main {
    public static void main(String[] args) {

        ViewStartScreen.printStartMessage();

        List<Droid> droids = new ArrayList<>();

        List<Droid> enemyDroids = new ArrayList<>();


        BattleDroidB1 battleDroid = new BattleDroidB1(100, 100, new BlusterGun());

        SuperBattleDroidB2 superBattleDroidB2 = new SuperBattleDroidB2(100, 100, new BlusterGun(), new RocketGun());

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
