package com.epam.lab.war.model.weapon;

import com.epam.lab.war.model.droid.constant.DroidContant;

import java.util.Random;

/**
 * Rocket gun. damage power is higher but accuracy is lower than in blusterGun
 */
public class RocketGun implements Gun {

    private int rocketCountInGun;
    final static int MAX_ROCKET_IN_GUN = DroidContant.MAX_ROCKET_IN_GUN;
    final static double SHOOT_ACCURACY = DroidContant.ROCKET_SHOOT_ACCURACY;


    public static double getShootAccuracy() {
        return SHOOT_ACCURACY;
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
}
