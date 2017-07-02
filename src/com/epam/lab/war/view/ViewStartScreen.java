package com.epam.lab.war.view;

/**
 * Created by Mykola on 29.06.2017.
 */
public class ViewStartScreen {
    public static void printStartMessage(){
        View view = new ConsoleView();
        view.println("                                     /~\\");
        view.println("                                    |oo )       Do you know where are we?");
        view.println("                                    _\\=/_       In WarOfTheDroids game!");
        view.println("                    ___            /  _  \\");
        view.println("                   / ()\\          //|/.\\|\\\\");
        view.println("                 _|_____|_       ||  \\_/  ||");
        view.println("                | | === | |      || |\\ /| ||");
        view.println("                |_|  O  |_|       # \\_ _/  #");
        view.println("                 ||  O  ||          | | |");
        view.println("                 ||__*__||          | | |");
        view.println("                |~ \\___/ ~|         []|[]");
        view.println("                /=\\ /=\\ /=\\         | | |");
        view.println("________________[_]_[_]_[_]________/_]_[_\\_________________________");
    }
}
