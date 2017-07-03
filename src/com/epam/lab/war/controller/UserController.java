package com.epam.lab.war.controller;

import com.epam.lab.war.model.droid.Droid;
import com.epam.lab.war.view.UserMessages;
import com.epam.lab.war.view.View;

import java.util.List;

/**
 * Created by Mykola on 03.07.2017.
 */
public class UserController {

    public List<Droid> setDroidControlledByUser(List<Droid> droids){
        int choosenDroid = 0;
        UserMessages userMessages = new UserMessages();
        choosenDroid = userMessages.chooseDroidToAct(droids);
        droids.get(choosenDroid).setUser(true);
        return droids;
    }

}
