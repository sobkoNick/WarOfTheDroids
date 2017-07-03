package com.epam.lab.war.model.droid;

import com.epam.lab.war.model.droid.constant.DroidContant;
import com.epam.lab.war.model.weapon.BlusterGun;
import com.epam.lab.war.model.weapon.RocketGun;

import java.util.List;
import java.util.Random;

/**
 * B2 droid has bluster and rocket
 */
public class SuperBattleDroidB2 extends BattleDroidB1 {
    Random random = new Random();

    private RocketGun rocketGun;

    public SuperBattleDroidB2(String type, boolean alive, boolean user, int healthLevel, int energyLevel,
                              int positionX, int positionY, BlusterGun blusterGun, RocketGun rocketGun) {
        super(type, alive, user, healthLevel, energyLevel, positionX, positionY, blusterGun);
        this.rocketGun = rocketGun;
    }

    public RocketGun getRocketGun() {
        return rocketGun;
    }

    public void setRocketGun(RocketGun rocketGun) {
        this.rocketGun = rocketGun;
    }

    public boolean rocketShoot() {
        return rocketGun.shoot();
    }

    @Override
    public List<Droid> decideWhichDroidToShoot(List<Droid> droids) {

        int droidNumber = 0;
        Droid droidToAttack = droids.get(0);
        for (Droid d: droids
                ) {
            if (d.getHealthLevel()  > droidToAttack.getHealthLevel()) {
                droidToAttack = d;
                droidNumber = droids.indexOf(d);
            }
        }

//        double damageOdd = 0;
//
//        if (GameController.fixedPositionField[droids.get(droidNumber).getPositionY()][droids.get(droidNumber).getPositionX()] == '1') {
//            damageOdd = 0.5;
//        }
//        if (GameController.fixedPositionField[droids.get(droidNumber).getPositionY()][droids.get(droidNumber).getPositionX()] == '2') {
//            damageOdd = 0;
//        }

        if (random.nextBoolean()) {
            if (shoot()) {
                int damageToEnemyDroid = DroidContant.BLUSTER_DAMAGE_POWER;
                droids.get(droidNumber).setDamage(damageToEnemyDroid);
//                droids.get(droidNumber).setHealthLevel(getHealthLevel() - damageToEnemyDroid);
            }
        } else {
            if (rocketShoot()) {
                int damageToEnemyDroid = DroidContant.ROCKET_DAMAGE_POWER;
                droids.get(droidNumber).setDamage(damageToEnemyDroid);
//                droids.get(droidNumber).setHealthLevel(getHealthLevel() - damageToEnemyDroid);
            }
        }
        return droids;
    }
}
