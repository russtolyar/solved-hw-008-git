package com.solvd.hw007;

import com.solvd.hw007.room.Heatable;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Polymorphism {

    private static final Logger LOGGER = LogManager.getLogger(Polymorphism.class);

    public void floorHeating(Heatable heat, Boolean hasHeat) {
        if (hasHeat) {
            heat.turnOn();
            LOGGER.debug("the floor is heating now");
        } else {
            LOGGER.debug("you cannot heat this floor");
        }
    }
}
