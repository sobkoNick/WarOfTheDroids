package com.epam.lab.war.model.droid;

import java.util.List;

/**
 * Created by Mykola on 30.06.2017.
 */
public class MechanicDroid extends Droid {
    public MechanicDroid(int healthLevel, int energyLevel, int positionX, int positionY) {
        super(healthLevel, energyLevel, positionX, positionY);
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
    public Droid decideWhichDroidToFix(List<Droid> droids) {
        Droid droidToFix = new MechanicDroid(100, 100, 0,0);
        for (Droid droid : droids) {
            if (droid.getHealthLevel() < droidToFix.getHealthLevel()) {
                droidToFix = droid;
            }
        }
        return droidToFix;
    }

    public void fixOtherDroid(Droid droid) {
        droid.setHealthLevel(droid.getHealthLevel() + 50);
    }
}
