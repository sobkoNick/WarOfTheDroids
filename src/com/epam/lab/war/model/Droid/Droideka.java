package com.epam.lab.war.model.droid;

import com.epam.lab.war.controller.GameController;
import com.epam.lab.war.model.droid.constant.DroidContant;
import com.epam.lab.war.model.weapon.BlusterGun;

import java.util.List;

/**
 * Droideka. has shield and 4 blusters.
 */
public class Droideka extends BattleDroidB1 {
    private BlusterGun blusterGun2;
    private BlusterGun blusterGun3;
    private BlusterGun blusterGun4;
    private int shieldHealthLevel;
    private boolean shieldActive;

    public Droideka(String type, boolean alive, boolean user, int healthLevel, int energyLevel,
                    int positionX, int positionY, BlusterGun blusterGun, BlusterGun blusterGun2, BlusterGun blusterGun3,
                    BlusterGun blusterGun4, int shieldHealthLevel, boolean shieldActive) {
        super(type, alive, user, healthLevel, energyLevel, positionX, positionY, blusterGun);
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
    public void move(int x, int y) {
        GameController.battleField[getPositionX()][getPositionY()] = '0';
        setPositionX(x);
        setPositionY(y);
        GameController.battleField[x][y] = 'D';
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
        int damageToEnemyDroid = shootFromAllWeapons() * DroidContant.BLUSTER_DAMAGE_POWER;
        droids.get(droidNumber).setDamage(damageToEnemyDroid);
//        droids.get(droidNumber).setHealthLevel(getHealthLevel() - damageToEnemyDroid);
        return droids;
    }

    public int shootFromAllWeapons() {
        int hitCounter = 0;
        setShieldActive(true);
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

    @Override
    public void setDamage(int damagePower) {
        if (shieldActive && getShieldHealthLevel() > 0) {
            setShieldHealthLevel(getHealthLevel() - damagePower);
        } else {
            setHealthLevel(getHealthLevel() - damagePower);
            if (getHealthLevel() <= 0) {
                setAlive(false);
                setHealthLevel(0);
            }
        }
    }


    @Override
    public String toString() {
        return super.toString() + "Droideka{" +
                "blusterGun2=" + blusterGun2 +
                ", blusterGun3=" + blusterGun3 +
                ", blusterGun4=" + blusterGun4 +
                ", shieldHealthLevel=" + shieldHealthLevel +
                ", shieldActive=" + shieldActive +
                '}';
    }
}
