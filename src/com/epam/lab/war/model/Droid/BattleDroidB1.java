package com.epam.lab.war.model.Droid;

import com.epam.lab.war.view.ConsoleView;
import com.epam.lab.war.view.View;

import java.util.Random;

/**
 * Created by Mykola on 29.06.2017.
 */
public class BattleDroidB1 extends Droid implements BattleDroid {
    private int ammunition;
    final static int DAMAGE_POWER = 3;

    public BattleDroidB1(int healthLevel, int energyLevel, int ammunition) {
        super(healthLevel, energyLevel);
        this.ammunition = ammunition;
    }

    public int getAmmunition() {
        return ammunition;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public static int getDamagePower() {
        return DAMAGE_POWER;
    }


    @Override
    public void move() {
        View view = new ConsoleView();
        view.print("Droid moved");
    }

    /**
     * Droid shoots with some accuracy level which defines if he shoot on target
     * true - shoot
     * false - missed
     */
    @Override
    public boolean shoot() {
        Random random = new Random();
        return random.nextBoolean();
    }

}
