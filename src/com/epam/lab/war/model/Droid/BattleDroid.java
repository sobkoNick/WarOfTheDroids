package com.epam.lab.war.model.Droid;

import java.util.List;

/**
 * Created by Mykola on 29.06.2017.
 */
public interface BattleDroid {
    boolean shoot();
    Droid decideWhichDroidToShoot(List<Droid> droids);
}
