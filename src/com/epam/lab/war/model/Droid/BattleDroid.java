package com.epam.lab.war.model.droid;

import java.util.List;

/**
 * Created by Mykola on 29.06.2017.
 */
public interface BattleDroid {
    boolean shoot();
    List<Droid> decideWhichDroidToShoot(List<Droid> droids);
}
