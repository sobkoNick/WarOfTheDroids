package com.epam.lab.war.view;

import com.epam.lab.war.controller.GameController;

/**
 * Print battle field
 */
public class ShowBattleField {
    View view = new ConsoleView();
    public void printBattleField() {
        for (int i = 0; i < GameController.battleField.length; i++) {
            view.print(String.format("\t%d", i));
        }
        view.println("");
        for (int i = 0; i < GameController.battleField.length; i++) {
            view.print("\t-");
        }
        view.println("");
        for (int i = 0; i < GameController.battleField.length; i++) {
            view.print(String.format("%d|", i));
            for (int j = 0; j < GameController.battleField.length; j++) {
                view.print(String.format("\t%c", GameController.battleField[i][j]));
            }
            view.println("");
        }
    }
}
