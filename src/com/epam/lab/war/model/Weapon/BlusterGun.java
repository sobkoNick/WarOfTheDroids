package com.epam.lab.war.model.Weapon;

import java.util.Random;

/**
 * Created by Mykola on 29.06.2017.
 */
public class BlusterGun implements Gun {

    private int blasterPowerLevel;
    final static int MAX_BLASTER_POWER_LEVEL = 100;
    final static int DAMAGE_POWER = 10;
    final static double SHOOT_ACCURACY = 0.8;

    public static int getDamagePower() {
        return DAMAGE_POWER;
    }

    public static double getShootAccuracy() {
        return SHOOT_ACCURACY;
    }

    public int getBlasterPowerLevel() {
        return blasterPowerLevel;
    }

    public void setBlasterPowerLevel(int blasterPowerLevel) {
        this.blasterPowerLevel = blasterPowerLevel;
    }

    public BlusterGun() {
        blasterPowerLevel = MAX_BLASTER_POWER_LEVEL;
    }

    @Override
    public boolean shoot() {
        blasterPowerLevel--;
        Random random = new Random();
        if (random.nextDouble() <= BlusterGun.getShootAccuracy()) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void recharge() {
        blasterPowerLevel = MAX_BLASTER_POWER_LEVEL;
    }
}
