package com.epam.lab.war.view;

import com.epam.lab.war.controller.Main;
import com.epam.lab.war.model.droid.Droid;

import java.util.List;

/**
 * Created by Mykola on 03.07.2017.
 */
public class UserMessages {
    View view = new ConsoleView();

    public int chooseDroidToAct(List<Droid> droids) {
        int chooseCounter = 0;
        view.println("Choose your droid:");
        for (Droid droid : droids
                ) {
            view.print(String.format("%d : ", chooseCounter++));
            view.println(droid.toString());
        }
        int userDroid = Main.scanner.nextInt();
        view.println(String.format("Now you control %s", droids.get(userDroid).toString()));
        return userDroid;
    }

    public int act(List<Droid> enemyDroids){
        int chooseCounter = 0;
        view.println("Choose droid to attack:");
        for (Droid droid : enemyDroids
                ) {
            view.print(String.format("%d : ", chooseCounter++));
            view.println(droid.toString());
        }
        return Main.scanner.nextInt();
    }

}
