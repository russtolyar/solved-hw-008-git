package com.solvd.buildinghouse.room;


public enum FloorCoverMaterial implements Layable {

    WOOD,
    LAMINAT,
    LENOLEUM;

    @Override
    public void toLay() {
        System.out.println("It can be layed only by professionals\n");
    }
}
