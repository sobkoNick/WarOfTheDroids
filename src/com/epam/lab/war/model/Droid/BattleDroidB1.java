package com.epam.lab.war.model.droid;

import com.epam.lab.war.controller.CreateDroid;
import com.epam.lab.war.controller.GameController;
import com.epam.lab.war.model.droid.constant.DroidContant;
import com.epam.lab.war.model.weapon.BlusterGun;

import java.util.List;
import java.util.Random;

/**
 * B1 class
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
    public void move(int x, int y) {
        GameController.battleField[getPositionX()][getPositionY()] = DroidContant.EMPTY_SPACE_SYMBOL;
        setPositionX(x);
        setPositionY(y);
        GameController.battleField[x][y] = DroidContant.B1_SYMBOL;
    }

    @Override
    public List<Droid> act(List<Droid> droids, boolean enemy) {
        Random random = new Random();
        if (random.nextBoolean()) {
            droids = decideWhichDroidToShoot(droids);
        } else {
            CreateDroid createDroid = new CreateDroid();
            List<Integer> positions = createDroid.generatePosition(enemy);
            move(positions.get(0), positions.get(1));
        }
        setEnergyLevel(getEnergyLevel() - DroidContant.ACTION_ENERGY_COST);
        if (getEnergyLevel() <= 0) {
            setAlive(false);
            setEnergyLevel(0);
        }
        return droids;
    }

    @Override
    public List<Droid> decideWhichDroidToShoot(List<Droid> droids) {
        int droidNumber = 0;
        Droid droidToAttack = droids.get(0);
        for (Droid droid : droids) {
            if (droid.getHealthLevel() > droidToAttack.getHealthLevel()) {
                droidToAttack = droid;
                droidNumber = droids.indexOf(droid);
            }
        }
        if (shoot()) {
            int damageToEnemyDroid = DroidContant.BLUSTER_DAMAGE_POWER;
            droids.get(droidNumber).setDamage(damageToEnemyDroid);
        }
        return droids;
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
