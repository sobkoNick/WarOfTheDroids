package com.epam.lab.war.model.Droid;

import com.epam.lab.war.model.Weapon.BlusterGun;
import com.epam.lab.war.view.ConsoleView;
import com.epam.lab.war.view.View;

import java.util.List;
import java.util.Random;

/**
 * Created by Mykola on 29.06.2017.
 */
public class BattleDroidB1 extends Droid implements BattleDroid {
    private BlusterGun blusterGun;

    public BattleDroidB1(int healthLevel, int energyLevel, BlusterGun blusterGun) {
        super(healthLevel, energyLevel);
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

    }

    public  void walk(){

    }

    /**
     * Droid shoots with some accuracy level which defines if he shoot on target
     * true - shoot
     * false - missed
     */
    @Override
    public boolean shoot() {
        return blusterGun.shoot();
    }

}
