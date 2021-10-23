package com.solvd.hw007.room;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Floor implements Heatable {

    private static final Logger LOGGER = LogManager.getLogger(Floor.class);

    private String material;
    private Boolean hasHeat;

    public Floor(String material, Boolean hasHeat) {
        this.material = material;
        this.hasHeat = hasHeat;
    }

    @Override
    public void turnOn() {
        if (hasHeat) {
            LOGGER.debug("heater is on");
        } else {
            LOGGER.debug("no heater on this floor");
        }
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Boolean getHeated() {
        return hasHeat;
    }

    public void setHeated(Boolean heated) {
        hasHeat = heated;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "material='" + material + '\'' +
                ", isHeated=" + hasHeat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return Objects.equals(material, floor.material) && Objects.equals(hasHeat, floor.hasHeat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(material, hasHeat);
    }
}
