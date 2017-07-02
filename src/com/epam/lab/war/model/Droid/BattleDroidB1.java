package com.epam.lab.war.model.droid;

import com.epam.lab.war.model.weapon.BlusterGun;

import java.util.List;

/**
 * Created by Mykola on 29.06.2017.
 */
public class BattleDroidB1 extends Droid implements BattleDroid {
    private BlusterGun blusterGun;

    public BattleDroidB1(int healthLevel, int energyLevel, int positionX, int positionY, BlusterGun blusterGun) {
        super(healthLevel, energyLevel, positionX, positionY);
        this.blusterGun = blusterGun;
    }

    public BlusterGun getBlusterGun() {
        return blusterGun;
    }

    public void setBlusterGun(BlusterGun blusterGun) {
        this.blusterGun = blusterGun;
    }

    @Override
    public void move() {
        walk();
    }

    @Override
    public Droid decideWhichDroidToShoot(List<Droid> droids) {
        return null;
    }

    public  void walk(){

    }

    /**
     * droid shoots with some accuracy level which defines if he shoot on target
     * true - shoot
     * false - missed
     */
    @Override
    public boolean shoot() {
        return blusterGun.shoot();
    }

}
