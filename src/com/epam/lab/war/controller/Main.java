package com.epam.lab.war.controller;


import java.util.Scanner;

/**
 * Main class. start the game
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
