package com.epam.lab.war.controller;

import com.epam.lab.war.view.ConsoleView;
import com.epam.lab.war.view.View;

/**
 * Controlls game process
 */
public class GameController {

    View view = new ConsoleView();

    private char[][] battleField = new char[12][12];

    public void printArr() {
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
}
