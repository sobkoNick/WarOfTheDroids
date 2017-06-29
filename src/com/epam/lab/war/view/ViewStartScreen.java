package com.epam.lab.war.view;

/**
 * Created by Mykola on 29.06.2017.
 */
public class ViewStartScreen {
    public static void printStartMessage(){
        View view = new ConsoleView();
        view.print("                                     /~\\");
        view.print("                                    |oo )       Do you know where are we?");
        view.print("                                    _\\=/_       In WarOfTheDroids game!");
        view.print("                    ___            /  _  \\");
        view.print("                   / ()\\          //|/.\\|\\\\");
        view.print("                 _|_____|_       ||  \\_/  ||");
        view.print("                | | === | |      || |\\ /| ||");
        view.print("                |_|  O  |_|       # \\_ _/  #");
        view.print("                 ||  O  ||          | | |");
        view.print("                 ||__*__||          | | |");
        view.print("                |~ \\___/ ~|         []|[]");
        view.print("                /=\\ /=\\ /=\\         | | |");
        view.print("________________[_]_[_]_[_]________/_]_[_\\_________________________");
    }
}
