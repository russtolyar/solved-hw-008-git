package com.solvd.building_house.room;

public enum CeilingColor {

    RED("Bad"),
    WHITE("Good"),
    BLUE("Europian"),
    BLACK("Middle"),
    YELLOW("So-so"),
    GREEN("Super"),
    PINK("Extra nice");

    private String quality;

    CeilingColor(String quality) {
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }
}
