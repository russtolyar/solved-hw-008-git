package com.solvd.hw007.sostav;

public enum ElementMaterial {
    WOODEN("Retro-style"),
    STEEL("Extra-strong"),
    BRICK("Warm and Strong"),
    BETON("Any shape");

    private String description;

    private ElementMaterial(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
