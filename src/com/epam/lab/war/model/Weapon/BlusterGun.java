package com.epam.lab.war.model.weapon;

import com.epam.lab.war.model.droid.constant.DroidContant;
import com.sun.org.apache.bcel.internal.classfile.Constant;

import java.util.Random;

/**
 * Bluster gun class
 */
public class BlusterGun implements Gun {

    private int blasterPowerLevel;
    final static int MAX_BLASTER_POWER_LEVEL = DroidContant.MAX_BLASTER_POWER_LEVEL;
    final static int DAMAGE_POWER = DroidContant.BLUSTER_DAMAGE_POWER;
    final static double SHOOT_ACCURACY = DroidContant.BLUSTER_SHOOT_ACCURACY;

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

    @Override
    public String toString() {
        return "BlusterGun{" +
                "blasterPowerLevel=" + blasterPowerLevel +
                '}';
    }
}
