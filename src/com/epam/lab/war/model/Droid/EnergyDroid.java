package com.epam.lab.war.model.droid;

import com.epam.lab.war.model.droid.constant.DroidContant;

import java.util.List;
import java.util.Random;

/**
 * Created by Mykola on 30.06.2017.
 */
public class EnergyDroid extends Droid {
    @Override
    public List<Droid> act(List<Droid> droids) {
        Random random = new Random();
        if (random.nextBoolean()) {
            droids = decideWhichDroidToRecharge(droids);
        } else {

        }
        return droids;
    }

    public EnergyDroid(String type, int healthLevel, int energyLevel, int positionX, int positionY) {
        super(type, healthLevel, energyLevel, positionX, positionY);
    }

    @Override
    public void move() {

    }

    /**
     * Decides which droid to recharge based on the lowest energyLevel
     *
     * @param droids
     * @return
     */

    public List<Droid> decideWhichDroidToRecharge(List<Droid> droids) {
        Droid droidToRecharge = new EnergyDroid(DroidContant.ENERGY_TYPE,100, 100, 0 ,0);
        for (Droid droid : droids) {
            if (droid.getEnergyLevel() < droidToRecharge.getEnergyLevel()) {
                droidToRecharge = droid;
            }
        }
        rechargeOtherDroid(droidToRecharge);
        return droids;
    }

    public void rechargeOtherDroid(Droid droid) {
        droid.setEnergyLevel(droid.getEnergyLevel() + 50);
        this.setEnergyLevel(this.getEnergyLevel() - 50);
    }
}
