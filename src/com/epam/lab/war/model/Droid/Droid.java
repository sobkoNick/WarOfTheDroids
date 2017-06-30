package com.epam.lab.war.model.Droid;

/**
 * Created by Mykola on 29.06.2017.
 */
public abstract class Droid {
    private int healthLevel;
    private int energyLevel;

    public Droid(int healthLevel, int energyLevel) {
        this.healthLevel = healthLevel;
        this.energyLevel = energyLevel;
    }

    public int getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(int healthLevel) {
        this.healthLevel = healthLevel;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void setEnergyLevel(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public abstract void move();

}
