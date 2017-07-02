package com.epam.lab.war.model.droid;

import com.epam.lab.war.model.weapon.BlusterGun;

import java.util.List;

/**
 * Created by Mykola on 30.06.2017.
 */
public class Droideka extends BattleDroidB1 {
    private BlusterGun blusterGun2;
    private BlusterGun blusterGun3;
    private BlusterGun blusterGun4;
    private int shieldHealthLevel;
    private boolean shieldActive;

    public Droideka(int healthLevel, int energyLevel, int positionX, int positionY, BlusterGun blusterGun, BlusterGun blusterGun2, BlusterGun blusterGun3,
                    BlusterGun blusterGun4, int shieldHealthLevel, boolean shieldActive) {
        super(healthLevel, energyLevel, positionX, positionY, blusterGun);
        this.blusterGun2 = blusterGun2;
        this.blusterGun3 = blusterGun3;
        this.blusterGun4 = blusterGun4;
        this.shieldHealthLevel = shieldHealthLevel;
        this.shieldActive = shieldActive;
    }

    public int getShieldHealthLevel() {
        return shieldHealthLevel;
    }

    public void setShieldHealthLevel(int shieldHealthLevel) {
        this.shieldHealthLevel = shieldHealthLevel;
    }

    public boolean isShieldActive() {
        return shieldActive;
    }

    public void setShieldActive(boolean shieldActive) {
        this.shieldActive = shieldActive;
    }

    @Override
    public void move() {

    }

    @Override
    public void walk() {
        useShield();
    }

    public void roll() {
        shieldActive = false;
    }

    public void useShield() {
        shieldActive = true;

    }
    public void getDamage(int damageSize) {
        if (shieldActive || shieldHealthLevel > damageSize) {
            shieldHealthLevel -= damageSize;
        } else {
            setHealthLevel(getHealthLevel() - damageSize);
        }
    }

    @Override
    public Droid decideWhichDroidToShoot(List<Droid> droids) {
        return null;
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
