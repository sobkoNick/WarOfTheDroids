package com.epam.lab.war.controller;

import com.epam.lab.war.model.droid.Droid;
import com.epam.lab.war.model.droid.constant.DroidContant;
import com.epam.lab.war.view.*;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Controlls game process
 */
public class GameController {

    View view = new ConsoleView();
    UserMessages userMessages = new UserMessages();
    UserController userController = new UserController();

    List<Droid> droids = new ArrayList<>();
    List<Droid> enemyDroids = new ArrayList<>();

    private int droidDekaNumber;
    private int b1Number;
    private int b2Number;
    private int mechanicDroidNumber;
    private int energyDroidNumber;
    private int battleCounter = 0;


    public static char[][] battleField = new char[12][12];
    public static char[][] fixedPositionField = new char[12][12];

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

        userController.setDroidControlledByUser(droids);
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
        ShowBattleField showBattleField = new ShowBattleField();
        showBattleField.printBattleField();
    }

    public void userMakeDecision() {
        if (userMessages.chooseAction() == 0) {
            List<Integer> newPosition = new LinkedList<>();
            newPosition = userMessages.moveToPosition();
            for (Droid droid : droids) {
                if (droid.isUser() && droid.isAlive()) {
                    droid.move(newPosition.get(1), newPosition.get(0));
                }
            }
        } else {
            int droidToAttack = userMessages.act(enemyDroids);
            for (Droid droid : droids) {
                if (droid.isUser() && droid.isAlive()) {
                    if (droid.getType().equals(DroidContant.MECHANIC_TYPE) || droid.getType().equals(DroidContant.ENERGY_TYPE)) {
                        droid.actForUser(droids.get(droidToAttack));
                    }
                    droid.actForUser(enemyDroids.get(droidToAttack));
                }
            }
        }
    }

    public void droidsAct() {
        for (int i = 0; i < droids.size(); i++) {
            if (!droids.get(i).isUser() && droids.get(i).isAlive()) {
                if (droids.get(i).getType().equals(DroidContant.ENERGY_TYPE) ||
                        droids.get(i).getType().equals(DroidContant.MECHANIC_TYPE)) {
                    droids.get(i).act(droids, false);
                } else {
                    droids.get(i).act(enemyDroids, false);
                }
            }
            if (enemyDroids.get(i).isAlive()) {
                if (enemyDroids.get(i).getType().equals(DroidContant.ENERGY_TYPE) ||
                        enemyDroids.get(i).getType().equals(DroidContant.MECHANIC_TYPE)) {
                    enemyDroids.get(i).act(enemyDroids, true);
                } else {
                    enemyDroids.get(i).act(droids, true);
                }
            }
        }
    }

    public void battleRound() {
        userMakeDecision();
        droidsAct();
        printResult();
    }
    public void printResult() {
        view.println(String.format("-----Results after round #%d--------", ++battleCounter));
        ShowBattleField showBattleField = new ShowBattleField();
        showBattleField.printBattleField();
        view.println("----------USER DROIDS------------");
        for (int i = 0; i < droids.size(); i++) {
            view.println(droids.get(i).toString());
        }
        view.println("----------AI DROIDS------------");
        for (int i = 0; i < enemyDroids.size(); i++) {
            view.println(enemyDroids.get(i).toString());
        }
        view.println("---------END OF ROUND-------------");
        decideWinner();
    }

    public void decideWinner() {
        int userDroidDeadCounter = 0;
        int enemyDroidDeadCounter = 0;
        for (Droid d : droids) {
            if (!d.isAlive()) {
                userDroidDeadCounter++;
            }
        }
        for (Droid d : enemyDroids) {
            if (!d.isAlive()) {
                enemyDroidDeadCounter++;
            }
        }
        if (userDroidDeadCounter == droids.size()) {
            view.println("!!!!!!!!!!!!AI WIN!!!!!!!!!!!!");
        } else if (enemyDroidDeadCounter == enemyDroids.size()) {
            view.println("!!!!!!!!!!!PLAYER WIN!!!!!!!!!!!!!");
        } else {
            battleRound();
        }
    }
}
