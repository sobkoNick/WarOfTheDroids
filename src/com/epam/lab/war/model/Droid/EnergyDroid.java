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

    public Droid decideWhichDroidToRecharge(List<Droid> droids){

    }

    public void rechargeOtherDroid(Droid droid) {
        droid.setEnergyLevel(droid.getEnergyLevel() + 50);
    }
}
