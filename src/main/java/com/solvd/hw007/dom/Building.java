package com.solvd.hw007.dom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public abstract class Building extends Conctruction implements Forceable {

    private static final Logger LOGGER = LogManager.getLogger(Building.class);

    private String type;

    public Building(String form, String type) {
        super(form);
        this.type = type;
    }

    @Override
    public void toForce() {

        LOGGER.debug("This building is well forced");

    }

    public abstract void printBuildingType();

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
