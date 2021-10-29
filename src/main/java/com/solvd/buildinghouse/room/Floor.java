package com.solvd.buildinghouse.room;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

import static com.solvd.buildinghouse.room.FloorCoverMaterial.*;

public class Floor implements Heatable {

    private static final Logger LOGGER = LogManager.getLogger(Floor.class);

    private FloorCoverMaterial floorCoverMaterial;
    private Boolean hasHeat;

    public Floor(Boolean hasHeat, FloorCoverMaterial floorCoverMaterial) {
        this.hasHeat = hasHeat;
        this.floorCoverMaterial = floorCoverMaterial;
    }

    public void floorCoverInfo() {
        if (WOOD.equals(floorCoverMaterial)) {
            LOGGER.debug("This floor cover is natural. It's - " + WOOD);
            WOOD.toLay();
        } else if (LAMINAT.equals(floorCoverMaterial)) {
            LOGGER.debug("This floor cover is semi-natural. It's - " + LAMINAT);
        } else {
            LOGGER.debug("This floor cover is synthetics. It's - " + LENOLEUM);
        }
    }

    @Override
    public void turnOn() {
        if (hasHeat) {
            LOGGER.debug("heater is on");
        } else {
            LOGGER.debug("no heater on this floor");
        }
    }

    public FloorCoverMaterial getFloorCoverMaterial() {
        return floorCoverMaterial;
    }

    public void setFloorCoverMaterial(FloorCoverMaterial floorCoverMaterial) {
        this.floorCoverMaterial = floorCoverMaterial;
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
                "material='" + floorCoverMaterial + '\'' +
                ", isHeated=" + hasHeat +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Floor floor = (Floor) o;
        return floorCoverMaterial == floor.floorCoverMaterial && Objects.equals(hasHeat, floor.hasHeat);
    }

    @Override
    public int hashCode() {
        return Objects.hash(floorCoverMaterial, hasHeat);
    }
}
