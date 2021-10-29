package com.solvd.buildinghouse.sostav;

import com.solvd.buildinghouse.exception.InvalidElementHeightException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

public class Element<T> {

    private static final Logger LOGGER = LogManager.getLogger(Element.class);

    private double length;
    private double height;
    private ElementMaterial elementMaterial;
    private T gost;

    public Element() {
    }

    public Element(double length, double height, ElementMaterial elementMaterial, T gost) {
        if (height < 0.1 || height > 5) {
            throw new InvalidElementHeightException("Impossible length");
        }
        this.length = length;

        if (height < 0.1 || height > 5) {
            throw new InvalidElementHeightException("Impossible height");
        }
        this.height = height;
        this.elementMaterial = elementMaterial;
        this.gost = gost;
    }

    public void printMaterialInfo() {
        switch (elementMaterial) {
            case BETON:
                LOGGER.debug("The Cheapest material is " + elementMaterial + " IT's - "
                        + elementMaterial.getDescription()
                        + " \nIt's length and height  are - " + length + " - " + height);
                break;
            case BRICK:
                LOGGER.debug("Best material " + elementMaterial + " is used here. IT's - " + elementMaterial.getDescription()
                        + " \nIt's length and height  are - " + length + " - " + height);
                break;
            case STEEL:
                LOGGER.debug("The most expensive material is " + elementMaterial + " IT's - " + elementMaterial.getDescription()
                        + " \nIt's length and height  are - " + length + " - " + height);
                break;
            case WOODEN:
                LOGGER.debug("Eco material is " + elementMaterial + " IT's - " + elementMaterial.getDescription()
                        + " \nIt's length and height  are - " + length + " - " + height);
            default: break;
        }
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        if (height < 0.1 || height > 5) {
            throw new InvalidElementHeightException("Impossible height");
        }
        this.height = height;
    }

    public T getGost() {
        return gost;
    }

    public void setGost(T gost) {
        this.gost = gost;
    }

    public ElementMaterial getElementMaterial() {
        return elementMaterial;
    }

    public void setElementMaterial(ElementMaterial elementMaterial) {
        this.elementMaterial = elementMaterial;
    }

    @Override
    public String toString() {
        return "This Element" +
                "length=" + length +
                ", height=" + height +
                ", material='" + elementMaterial +
                ", and it's - " + elementMaterial.getDescription() + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element<?> element = (Element<?>) o;
        return Double.compare(element.length, length) == 0
                && Double.compare(element.height, height) == 0
                && Objects.equals(elementMaterial, element.elementMaterial);
    }

    @Override
    public int hashCode() {
        return Objects.hash(length, height, elementMaterial);
    }
}