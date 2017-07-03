package com.epam.lab.war.model.droid;

import com.epam.lab.war.model.droid.constant.DroidContant;

import java.util.List;
import java.util.Random;

/**
 * Created by Mykola on 30.06.2017.
 */
public class MechanicDroid extends Droid {
    @Override
    public List<Droid> act(List<Droid> droids) {
        Random random = new Random();
        if (random.nextBoolean()) {
            droids = decideWhichDroidToFix(droids);
        } else {

        }
        return droids;
    }

    public MechanicDroid(String type, int healthLevel, int energyLevel, int positionX, int positionY) {
        super(type, healthLevel, energyLevel, positionX, positionY);
    }

    @Override
    public void move() {

    }

    /**
     * Decides which droid to fix based on the lowest healthLevel
     *
     * @param droids
     * @return
     */
    public List<Droid> decideWhichDroidToFix(List<Droid> droids) {
        Droid droidToFix = new MechanicDroid(DroidContant.MECHANIC_TYPE,100, 100, 0,0);
        for (Droid droid : droids) {
            if (droid.getHealthLevel() < droidToFix.getHealthLevel()) {
                droidToFix = droid;
            }
        }
        fixOtherDroid(droidToFix);
        return droids;
    }

    public void fixOtherDroid(Droid droid) {
        droid.setHealthLevel(droid.getHealthLevel() + 50);
    }
}
