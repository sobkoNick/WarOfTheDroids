package com.epam.lab.war.model.droid;

import com.epam.lab.war.model.droid.constant.DroidContant;
import com.epam.lab.war.model.weapon.BlusterGun;

import java.util.List;
import java.util.Random;

/**
 * Created by Mykola on 29.06.2017.
 */
public class BattleDroidB1 extends Droid implements BattleDroid {

    private BlusterGun blusterGun;

    public BattleDroidB1(String type, boolean alive, boolean user, int healthLevel,
                         int energyLevel, int positionX, int positionY, BlusterGun blusterGun) {
        super(type, alive, user, healthLevel, energyLevel, positionX, positionY);
        this.blusterGun = blusterGun;
    }

    public BlusterGun getBlusterGun() {
        return blusterGun;
    }

    public void setBlusterGun(BlusterGun blusterGun) {
        this.blusterGun = blusterGun;
    }

    @Override
    public Droid actForUser(Droid droid) {
        if (shoot()) {
            droid.setDamage(DroidContant.BLUSTER_DAMAGE_POWER);
        }
        return droid;
    }

    @Override
    public void move() {
        walk();
    }

    @Override
    public List<Droid> act(List<Droid> droids) {
        Random random = new Random();
        if (random.nextBoolean()) {
            droids = decideWhichDroidToShoot(droids);
        } else {
            // move
        }
        setEnergyLevel(getEnergyLevel() - 5);
        if (getEnergyLevel() <= 0){
            setAlive(false);
            setEnergyLevel(0);
        }
        return droids;
    }

    @Override
    public List<Droid> decideWhichDroidToShoot(List<Droid> droids) {
        int droidNumber = 0;
        Droid droidToAttack = droids.get(0);
        for (Droid d : droids
                ) {
            if (d.getHealthLevel() > droidToAttack.getHealthLevel()) {
                droidToAttack = d;
                droidNumber = droids.indexOf(d);
            }
        }
        if (shoot()) {
            int damageToEnemyDroid = DroidContant.BLUSTER_DAMAGE_POWER;
            droids.get(droidNumber).setDamage(damageToEnemyDroid);
//            droids.get(droidNumber).setHealthLevel(getHealthLevel() - damageToEnemyDroid);
        }
        return droids;
    }

    public void walk() {
//        List<Integer> positionList = new LinkedList<>();
//
//        if (GameController.battleField[positionY][positionX] == '0' ||
//                GameController.battleField[positionY][positionX] == '1' ||
//                GameController.battleField[positionY][positionX] == '2') {
//
//        }
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

    @Override
    public void setDamage(int damagePower) {
        setHealthLevel(getHealthLevel() - damagePower);
        if (getHealthLevel() <= 0) {
            setAlive(false);
            setHealthLevel(0);
        }
    }
}
