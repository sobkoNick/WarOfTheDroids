package com.epam.lab.war.model.droid;

import com.epam.lab.war.model.droid.constant.DroidContant;
import com.epam.lab.war.model.weapon.BlusterGun;
import com.epam.lab.war.model.weapon.RocketGun;

import java.util.List;
import java.util.Random;

/**
 * Created by Mykola on 29.06.2017.
 */
public class SuperBattleDroidB2 extends BattleDroidB1 {
    Random random = new Random();

    private RocketGun rocketGun;

    public SuperBattleDroidB2(String type, int healthLevel, int energyLevel, int positionX, int positionY, BlusterGun blusterGun, RocketGun rocketGun) {
        super(type, healthLevel, energyLevel, positionX, positionY, blusterGun);
        this.rocketGun = rocketGun;
    }

    public RocketGun getRocketGun() {
        return rocketGun;
    }

    public void setRocketGun(RocketGun rocketGun) {
        this.rocketGun = rocketGun;
    }

    public void chooseWeapon() {
        Random random = new Random();
        if (random.nextBoolean()) {
            shoot();
        } else {
            rocketShoot();
        }
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

        if (random.nextBoolean()) {
            if (shoot()) {
                int damageToEnemyDroid = DroidContant.BLUSTER_DAMAGE_POWER;
                droids.get(droidNumber).setHealthLevel(getHealthLevel() - damageToEnemyDroid);
            }
        } else {
            if (rocketShoot()) {
                int damageToEnemyDroid = DroidContant.ROCKET_DAMAGE_POWER;
                droids.get(droidNumber).setHealthLevel(getHealthLevel() - damageToEnemyDroid);
            }
        }
        return droids;
    }
    //    public void useShield() {
//        View view = new ConsoleView();
//        view.print("B2 now uses shield");
//    }
}
