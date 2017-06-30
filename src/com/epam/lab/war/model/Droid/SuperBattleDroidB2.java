package com.epam.lab.war.model.Droid;

import com.epam.lab.war.model.Weapon.BlusterGun;
import com.epam.lab.war.model.Weapon.RocketGun;

import java.util.List;
import java.util.Random;

/**
 * Created by Mykola on 29.06.2017.
 */
public class SuperBattleDroidB2 extends BattleDroidB1 {
    private RocketGun rocketGun;

    public SuperBattleDroidB2(int healthLevel, int energyLevel, BlusterGun blusterGun, RocketGun rocketGun) {
        super(healthLevel, energyLevel, blusterGun);
        this.rocketGun = rocketGun;
    }

    public RocketGun getRocketGun() {
        return rocketGun;
    }

    public void setRocketGun(RocketGun rocketGun) {
        this.rocketGun = rocketGun;
    }

    public void chooseWeapon(){
        Random random = new Random();
        if (random.nextBoolean()) {
            shoot();
        } else {
            rocketShoot();
        }
    }

    public boolean rocketShoot(){
        return rocketGun.shoot();
    }

    @Override
    public Droid decideWhichDroidToShoot(List<Droid> droids) {

    }
    //    public void useShield() {
//        View view = new ConsoleView();
//        view.print("B2 now uses shield");
//    }
}
