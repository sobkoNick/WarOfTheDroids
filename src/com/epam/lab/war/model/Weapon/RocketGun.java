package com.epam.lab.war.model.weapon;

import com.epam.lab.war.model.droid.constant.DroidContant;

import java.util.Random;

/**
 * Rocket gun. damage power is higher but accuracy is lower than in blusterGun
 */
public class RocketGun implements Gun {

    private int rocketCountInGun;
    final static int MAX_ROCKET_IN_GUN = DroidContant.MAX_ROCKET_IN_GUN;
    final static int DAMAGE_POWER = DroidContant.ROCKET_DAMAGE_POWER;
    final static double SHOOT_ACCURACY = DroidContant.ROCKET_SHOOT_ACCURACY;

    public static int getDamagePower() {
        return DAMAGE_POWER;
    }

    public static double getShootAccuracy() {
        return SHOOT_ACCURACY;
    }

    public int getRocketCountInGun() {
        return rocketCountInGun;
    }

    public void setRocketCountInGun(int rocketCountInGun) {
        this.rocketCountInGun = rocketCountInGun;
    }

    public RocketGun() {
        rocketCountInGun = MAX_ROCKET_IN_GUN;
    }

    @Override
    public boolean shoot() {
        rocketCountInGun--;
        Random random = new Random();
        if (random.nextDouble() <= RocketGun.getShootAccuracy()){
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void recharge() {
        rocketCountInGun = MAX_ROCKET_IN_GUN;
    }
}
