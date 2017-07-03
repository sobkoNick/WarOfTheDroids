package com.epam.lab.war.model.droid;

import java.util.List;

/**
 * General abstract Droid class
 */
public abstract class Droid {
    private String type;
    private boolean alive;
    private boolean user;
    private int healthLevel;
    private int energyLevel;
    private int positionX;
    private int positionY;

    public Droid(String type, boolean alive, boolean user, int healthLevel, int energyLevel, int positionX, int positionY) {
        this.type = type;
        this.alive = alive;
        this.user = user;
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

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public boolean isUser() {
        return user;
    }

    public void setUser(boolean user) {
        this.user = user;
    }

    public abstract Droid actForUser(Droid droid);

    public abstract void move(int x, int y);

    public abstract List<Droid> act(List<Droid> droids, boolean enemy);

    public abstract void setDamage(int damagePower);

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
