package com.epam.lab.war.model.Weapon;

/**
 * Created by Mykola on 29.06.2017.
 */
public class RocketGun implements Gun {

    private int rocketCountInGun;
    final static int MAX_ROCKET_IN_GUN = 10;
    final static int DAMAGE_POWER = 50;

    public RocketGun() {
        rocketCountInGun = MAX_ROCKET_IN_GUN;
    }

    @Override
    public void shoot() {
        rocketCountInGun--;
    }

    @Override
    public void recharge() {
        rocketCountInGun = MAX_ROCKET_IN_GUN;
    }
}
