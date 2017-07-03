package com.epam.lab.war.controller;

import com.epam.lab.war.model.droid.Droid;
import com.epam.lab.war.model.droid.constant.DroidContant;
import com.epam.lab.war.view.ConsoleView;
import com.epam.lab.war.view.View;
import com.epam.lab.war.view.ViewStartScreen;

import java.util.ArrayList;
import java.util.List;

/**
 * Controlls game process
 */
public class GameController {

    View view = new ConsoleView();

    List<Droid> droids = new ArrayList<>();
    List<Droid> enemyDroids = new ArrayList<>();

    private int droidDekaNumber;
    private int b1Number;
    private int b2Number;
    private int mechanicDroidNumber;
    private int energyDroidNumber;


    public static char[][] battleField = new char[12][12];

    public void setUpBattleField() {
        for (int i = 0; i < battleField.length; i++) {
            for (int j = 0; j < battleField.length; j++) {
                battleField[i][j] = '0';
            }
        }

        for (int i = 3; i < 9; i++) {
            battleField[i][0] = '-';
            battleField[i][battleField.length - 1] = '-';
            battleField[i][4] = '-';
            battleField[i][5] = '-';
            battleField[i][6] = '-';
            battleField[i][7] = '-';
        }

        battleField[2][0] = '1';
        battleField[2][4] = '1';
        battleField[2][7] = '1';
        battleField[2][11] = '1';

        battleField[9][0] = '1';
        battleField[9][4] = '1';
        battleField[9][7] = '1';
        battleField[9][11] = '1';

        battleField[2][5] = '2';
        battleField[2][6] = '2';

        battleField[9][5] = '2';
        battleField[9][6] = '2';

        printBattleField();
    }

    public void printBattleField() {
        for (int i = 0; i < battleField.length; i++) {
            view.print(String.format("\t%d", i));
        }
        view.println("");
        for (int i = 0; i < battleField.length; i++) {
            view.print("\t-");
        }

        view.println("");
        for (int i = 0; i < battleField.length; i++) {
            view.print(String.format("%d|", i));
            for (int j = 0; j < battleField.length; j++) {
                view.print(String.format("\t%c", battleField[i][j]));
            }
            view.println("");
        }
    }

    public void startGame() {
        ViewStartScreen.printStartMessage();
        view.println("");

        view.println("Time to choose droids in your team. AI will have the same count and type of droids.");

        view.println("Droideka count?");
        droidDekaNumber = Main.scanner.nextInt();
        view.println("BattleDroidB1 count?");
        b1Number = Main.scanner.nextInt();
        view.println("SuperBattleDroidB2 count?");
        b2Number = Main.scanner.nextInt();
        view.println("MechanicDroid count?");
        mechanicDroidNumber = Main.scanner.nextInt();
        view.println("EnergyDroid count?");
        energyDroidNumber = Main.scanner.nextInt();

        createDroidList();
    }

    public void createDroidList() {
        CreateDroid createDroid = new CreateDroid();
        if (droidDekaNumber > 0) {
            for (int i = 0; i < droidDekaNumber; i++) {
                droids.add(createDroid.createDekaDroid(false));
                enemyDroids.add(createDroid.createDekaDroid(true));
            }
        }
        if (b1Number > 0) {
            for (int i = 0; i < b1Number; i++) {
                droids.add(createDroid.createBattleDroidB1(false));
                enemyDroids.add(createDroid.createBattleDroidB1(true));
            }
        }
        if (b2Number > 0) {
            for (int i = 0; i < b2Number; i++) {
                droids.add(createDroid.createSuperB2(false));
                enemyDroids.add(createDroid.createSuperB2(true));
            }
        }
        if (mechanicDroidNumber > 0) {
            for (int i = 0; i < mechanicDroidNumber; i++) {
                droids.add(createDroid.createMechanicDroid(false));
                enemyDroids.add(createDroid.createMechanicDroid(true));
            }
        }
        if (energyDroidNumber > 0) {
            for (int i = 0; i < energyDroidNumber; i++) {
                droids.add(createDroid.createEnergyDroid(false));
                enemyDroids.add(createDroid.createEnergyDroid(true));
            }
        }
        printBattleField();
    }

    public void battleRound(){
        for (int i = 0; i < droids.size(); i++) {
            if (droids.get(i).getType().equals(DroidContant.ENERGY_TYPE) || droids.get(i).getType().equals(DroidContant.MECHANIC_TYPE)) {
                droids.get(i).act(droids);
            } else {
                droids.get(i).act(enemyDroids);
            }
            if (enemyDroids.get(i).getType().equals(DroidContant.ENERGY_TYPE) || enemyDroids.get(i).getType().equals(DroidContant.MECHANIC_TYPE)) {
                enemyDroids.get(i).act(enemyDroids);
            } else {
                enemyDroids.get(i).act(droids);
            }
        }

        for (int i = 0; i < droids.size(); i++) {
            view.println(droids.get(i).toString());
        }

        view.println("----------------------");

        for (int i = 0; i < enemyDroids.size(); i++) {
            view.println(enemyDroids.get(i).toString());
        }
        view.println("---------END OF ROUND-------------");
    }

//    public int inputInt() {
//        int tempVar = 0;
//        try {
//            tempVar = Main.scanner.nextInt();
//        } catch (InputMismatchException e) {
//            view.println("You inputed wrong value. Try once more");
//            tempVar = Main.scanner.nextInt();
//        }
//        return tempVar;
//    }
}
