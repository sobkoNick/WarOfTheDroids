package com.epam.lab.war.model.Droid;

import java.util.List;

/**
 * Created by Mykola on 30.06.2017.
 */
public class MechanicDroid extends Droid {
    public MechanicDroid(int healthLevel, int energyLevel) {
        super(healthLevel, energyLevel);
    }

    @Override
    public void move() {

    }

    public Droid decideWhichDroidToFix(List<Droid> droids){

    }

    public void fixOtherDroid(Droid droid) {
        droid.setHealthLevel(droid.getHealthLevel() + 50);
    }
}
