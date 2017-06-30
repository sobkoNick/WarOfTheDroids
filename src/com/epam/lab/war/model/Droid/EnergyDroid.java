package com.epam.lab.war.model.Droid;

import java.util.List;

/**
 * Created by Mykola on 30.06.2017.
 */
public class EnergyDroid extends Droid {
    public EnergyDroid(int healthLevel, int energyLevel) {
        super(healthLevel, energyLevel);
    }

    @Override
    public void move() {

    }

    /**
     * Decides which droid to recharge based on the lowest energyLevel
     * @param droids
     * @return
     */

    public Droid decideWhichDroidToRecharge(List<Droid> droids){
        Droid droidToRecharge = new EnergyDroid(100, 100);
        for (Droid droid: droids) {
            if (droid.getEnergyLevel() < droidToRecharge.getEnergyLevel()) {
                droidToRecharge = droid;
            }
        }
        return droidToRecharge;
    }

    public void rechargeOtherDroid(Droid droid) {
        droid.setEnergyLevel(droid.getEnergyLevel() + 50);
    }
}
