package com.epam.lab.war.model.droid;

import com.epam.lab.war.controller.GameController;
import com.epam.lab.war.model.droid.constant.DroidContant;

import java.util.List;

/**
 * Energy droid recharges other droids
 */
public class EnergyDroid extends Droid {

    public EnergyDroid(String type, boolean alive, boolean user,
                       int healthLevel, int energyLevel, int positionX, int positionY) {
        super(type, alive, user, healthLevel, energyLevel, positionX, positionY);
    }

    @Override
    public List<Droid> act(List<Droid> droids, boolean enemy) {
        droids = decideWhichDroidToRecharge(droids);
        setEnergyLevel(getEnergyLevel() - 5);
        return droids;
    }

    @Override
    public void move(int x, int y) {
        GameController.battleField[getPositionX()][getPositionY()] = '0';
        setPositionX(x);
        setPositionY(y);
        GameController.battleField[x][y] = 'E';
    }

    @Override
    public Droid actForUser(Droid droid) {
        rechargeOtherDroid(droid);
        return droid;
    }

    /**
     * Decides which droid to recharge based on the lowest energyLevel
     *
     * @param droids
     * @return
     */
    public List<Droid> decideWhichDroidToRecharge(List<Droid> droids) {
        Droid droidToRecharge = new EnergyDroid(DroidContant.ENERGY_TYPE, true, false, 100, 100, 0, 0);
        for (Droid droid : droids) {
            if (droid.getEnergyLevel() < droidToRecharge.getEnergyLevel()) {
                droidToRecharge = droid;
            }
        }
        move(droidToRecharge.getPositionX(), droidToRecharge.getPositionY());
        rechargeOtherDroid(droidToRecharge);
        return droids;
    }

    public void rechargeOtherDroid(Droid droid) {
        if (getEnergyLevel() > 0) {
            droid.setEnergyLevel(droid.getEnergyLevel() + DroidContant.ENERGY_DROID_RECHARGE_POWER);
            this.setEnergyLevel(this.getEnergyLevel() - DroidContant.ENERGY_DROID_RECHARGE_POWER);
        } else {
            setEnergyLevel(0);
            setAlive(false);
        }
        if (!droid.isAlive() && droid.getHealthLevel() > 0)
            droid.setAlive(true);
        setEnergyLevel(getEnergyLevel() - DroidContant.ACTION_ENERGY_COST);
    }

    @Override
    public void setDamage(int damagePower) {
        setHealthLevel(getHealthLevel() - damagePower);
        if (getHealthLevel() <= 0) {
            setAlive(false);
            setHealthLevel(0);
        }
    }
}
