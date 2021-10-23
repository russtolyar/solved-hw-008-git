package com.solvd.hw007.room;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Ceiling implements Colorable {

    private static final Logger LOGGER = LogManager.getLogger(Ceiling.class);

    private Boolean hasLight;
    private String color;

    public Ceiling(boolean hasLight, String color) {
        this.hasLight = hasLight;
        this.color = color;
    }

    public void printCeilInfo() {
        LOGGER.debug("This ceiling has " + color + " color");
    }

    @Override
    public void toColor() {
        LOGGER.debug("The ceiling is colored in " + color + "  Color");
    }

    public void printCeilInfo(Boolean isLighted) {
        LOGGER.debug("This ceiling has " + color + " color ; And It well lighted - " + isLighted);
    }

    public boolean isLighted() {
        return hasLight;
    }

    public void setLighted(boolean lighted) {
        hasLight = lighted;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Ceiling{" +
                "isLighted=" + hasLight +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ceiling ceiling = (Ceiling) o;
        return Objects.equals(hasLight, ceiling.hasLight) && Objects.equals(color, ceiling.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasLight, color);
    }
}
