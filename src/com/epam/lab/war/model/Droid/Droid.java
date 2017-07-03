package com.epam.lab.war.model.droid;

import java.util.List;

/**
 * Created by Mykola on 29.06.2017.
 */
public abstract class Droid {
    private String type;
    private int healthLevel;
    private int energyLevel;
    private int positionX;
    private int positionY;

    public Droid(String type, int healthLevel, int energyLevel, int positionX, int positionY) {
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void move();

    public abstract List<Droid> act(List<Droid> droids);

    @Override
    public String toString() {
        return "Droid{" +
                "type='" + type + '\'' +
                ", healthLevel=" + healthLevel +
                ", energyLevel=" + energyLevel +
                ", positionX=" + positionX +
                ", positionY=" + positionY +
                '}';
    }
}
