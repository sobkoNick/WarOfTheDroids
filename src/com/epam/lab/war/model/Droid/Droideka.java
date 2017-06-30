package com.epam.lab.war.model.Droid;

import com.epam.lab.war.model.Weapon.BlusterGun;

import java.util.List;

/**
 * Created by Mykola on 30.06.2017.
 */
public class Droideka extends BattleDroidB1 {
    private BlusterGun blusterGun2;
    private BlusterGun blusterGun3;
    private BlusterGun blusterGun4;

    public Droideka(int healthLevel, int energyLevel, BlusterGun blusterGun,
                    BlusterGun blusterGun2, BlusterGun blusterGun3, BlusterGun blusterGun4) {
        super(healthLevel, energyLevel, blusterGun);
        this.blusterGun2 = blusterGun2;
        this.blusterGun3 = blusterGun3;
        this.blusterGun4 = blusterGun4;
    }

    @Override
    public void move() {

    }

    @Override
    public void walk() {

    }

    public void roll() {

    }

    public void useShield() {

    }

    @Override
    public Droid decideWhichDroidToShoot(List<Droid> droids) {

    }

    public int shootFromAllWeapons() {
        int hitCounter = 0;
        if (getBlusterGun().shoot()) {
            hitCounter++;
        }
        if (blusterGun2.shoot()) {
            hitCounter++;
        }
        if (blusterGun3.shoot()) {
            hitCounter++;
        }
        if (blusterGun4.shoot()) {
            hitCounter++;
        }
        return hitCounter;
    }

}
