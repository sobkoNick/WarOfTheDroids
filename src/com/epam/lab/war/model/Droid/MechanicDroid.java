package com.epam.lab.war.model.droid;

import com.epam.lab.war.controller.GameController;
import com.epam.lab.war.model.droid.constant.DroidContant;

import java.util.List;

/**
 * Mechanic droids fix other damaged droids
 */
public class MechanicDroid extends Droid {
    public MechanicDroid(String type, boolean alive, boolean user,
                         int healthLevel, int energyLevel, int positionX, int positionY) {
        super(type, alive, user, healthLevel, energyLevel, positionX, positionY);
    }

    @Override
    public List<Droid> act(List<Droid> droids, boolean enemy) {
        droids = decideWhichDroidToFix(droids);
        setEnergyLevel(getEnergyLevel() - 5);
        if (getEnergyLevel() <= 0) {
            setAlive(false);
            setEnergyLevel(0);
        }
        return droids;
    }

    @Override
    public void move(int x, int y) {
        GameController.battleField[getPositionX()][getPositionY()] = '0';
        setPositionX(x);
        setPositionY(y);
        GameController.battleField[x][y] = 'M';
    }

    @Override
    public Droid actForUser(Droid droid) {
        fixOtherDroid(droid);
        return droid;
    }

    /**
     * Decides which droid to fix based on the lowest healthLevel
     *
     * @param droids
     * @return
     */
    public List<Droid> decideWhichDroidToFix(List<Droid> droids) {
        Droid droidToFix = new MechanicDroid(DroidContant.MECHANIC_TYPE, true, false,
                100, 100, 0, 0);
        for (Droid droid : droids) {
            if (droid.getHealthLevel() < droidToFix.getHealthLevel()) {
                droidToFix = droid;
            }
        }
        move(droidToFix.getPositionX(), droidToFix.getPositionY());
        fixOtherDroid(droidToFix);
        return droids;
    }

    public void fixOtherDroid(Droid droid) {
        droid.setHealthLevel(droid.getHealthLevel() + 20);
        if (!droid.isAlive() && droid.getEnergyLevel() > 0)
            droid.setAlive(true);
        setEnergyLevel(getEnergyLevel() - 5);
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
