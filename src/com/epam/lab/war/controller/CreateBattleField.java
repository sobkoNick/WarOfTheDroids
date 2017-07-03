package com.epam.lab.war.controller;

/**
 * Set up the Battle Field
 */
public class CreateBattleField {
    public static void setUpBattleField() {
        for (int i = 0; i < GameController.battleField.length; i++) {
            for (int j = 0; j < GameController.battleField.length; j++) {
                GameController.battleField[i][j] = '0';
            }
        }

        for (int i = 3; i < 9; i++) {
            GameController.battleField[i][0] = '-';
            GameController.battleField[i][GameController.battleField.length - 1] = '-';
            GameController.battleField[i][4] = '-';
            GameController.battleField[i][5] = '-';
            GameController.battleField[i][6] = '-';
            GameController.battleField[i][7] = '-';
        }

        GameController.battleField[2][0] = '1';
        GameController.battleField[2][4] = '1';
        GameController.battleField[2][7] = '1';
        GameController.battleField[2][11] = '1';

        GameController.battleField[9][0] = '1';
        GameController.battleField[9][4] = '1';
        GameController.battleField[9][7] = '1';
        GameController.battleField[9][11] = '1';

        GameController.battleField[2][5] = '2';
        GameController.battleField[2][6] = '2';

        GameController.battleField[9][5] = '2';
        GameController.battleField[9][6] = '2';

        GameController.fixedPositionField = GameController.battleField;
    }
}
