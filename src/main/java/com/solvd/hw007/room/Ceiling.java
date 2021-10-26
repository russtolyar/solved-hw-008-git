package com.solvd.hw007.room;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Ceiling implements Colorable {

    private static final Logger LOGGER = LogManager.getLogger(Ceiling.class);

    private Boolean hasLight;
    CeilingColor ceilingColor;

    public Ceiling(boolean hasLight, CeilingColor ceilingColor) {
        this.hasLight = hasLight;
        this.ceilingColor = ceilingColor;
    }

    public void printCeilInfo() {
        switch (ceilingColor) {
            case RED:
            case BLUE:
            case PINK:
            case WHITE:
                LOGGER.debug("This ceiling has " + ceilingColor + " color, It's Belorusian");
                break;
            case GREEN:
            case BLACK:
            case YELLOW:
                LOGGER.debug("This ceiling has " + ceilingColor + " color. It's imported");
                break;

        }
    }

    @Override
    public void toColor() {
        LOGGER.debug("The ceiling is colored in " + ceilingColor + "  Color");
    }

    public void printCeilInfo(Boolean isLighted) {
        LOGGER.debug("This ceiling has " + ceilingColor + " color, It's quality is "
                + ceilingColor.getQuality() + " ; And It well lighted - " + isLighted);
    }

    public boolean isLighted() {
        return hasLight;
    }

    public void setLighted(boolean lighted) {
        hasLight = lighted;
    }

    public CeilingColor getCeilingColor() {
        return ceilingColor;
    }

    public void setCeilingColor(CeilingColor ceilingColor) {
        this.ceilingColor = ceilingColor;
    }

    @Override
    public String toString() {
        return "Ceiling{" +
                "isLighted=" + hasLight +
                ", color='" + ceilingColor + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ceiling ceiling = (Ceiling) o;
        return Objects.equals(hasLight, ceiling.hasLight) && Objects.equals(ceilingColor, ceiling.ceilingColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hasLight, ceilingColor);
    }
}
