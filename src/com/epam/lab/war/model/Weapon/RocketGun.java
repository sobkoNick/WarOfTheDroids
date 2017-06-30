package com.epam.lab.war.model.Weapon;

import java.util.Random;

/**
 * Created by Mykola on 29.06.2017.
 */
public class RocketGun implements Gun {

    private int rocketCountInGun;
    final static int MAX_ROCKET_IN_GUN = 10;
    final static int DAMAGE_POWER = 50;
    final static double SHOOT_ACCURACY = 0.5;

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
