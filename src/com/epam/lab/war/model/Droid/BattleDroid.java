package com.epam.lab.war.model.droid;

import java.util.List;

/**
 * Battle Droid Interface
 */
public interface BattleDroid {
    boolean shoot();
    List<Droid> decideWhichDroidToShoot(List<Droid> droids);
}
