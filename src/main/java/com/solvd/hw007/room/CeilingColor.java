package com.solvd.hw007.room;

public enum CeilingColor {

    RED("Bad"),
    WHITE("Good"),
    BLUE("Europian"),
    BLACK("Middle"),
    YELLOW("So-so"),
    GREEN("Super"),
    PINK("Extra nice");

    private String quality;

    private CeilingColor(String quality) {
        this.quality = quality;
    }

    public String getQuality() {
        return quality;
    }
}
