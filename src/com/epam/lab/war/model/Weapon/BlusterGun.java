package com.epam.lab.war.model.Weapon;

/**
 * Created by Mykola on 29.06.2017.
 */
public class BlusterGun implements Gun {

    private int blasterPowerLevel;
    final static int MAX_BLASTER_POWER_LEVEL = 100;
    final static int DAMAGE_POWER = 10;

    public BlusterGun() {
        blasterPowerLevel = MAX_BLASTER_POWER_LEVEL;
    }

    @Override
    public void shoot() {
        blasterPowerLevel--;
    }

    @Override
    public void recharge() {
        blasterPowerLevel = MAX_BLASTER_POWER_LEVEL;
    }
}
