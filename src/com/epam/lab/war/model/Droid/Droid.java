package com.epam.lab.war.model.droid;

/**
 * Created by Mykola on 29.06.2017.
 */
public abstract class Droid {
    private int healthLevel;
    private int energyLevel;
    private int positionX;
    private int positionY;

    public Droid(int healthLevel, int energyLevel, int positionX, int positionY) {
        this.healthLevel = healthLevel;
        this.energyLevel = energyLevel;
        this.positionX = positionX;
        this.positionY = positionY;
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

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public abstract void move();

}
