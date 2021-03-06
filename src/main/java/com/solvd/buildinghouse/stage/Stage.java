
package com.solvd.buildinghouse.stage;

import com.solvd.buildinghouse.Paintable;
import com.solvd.buildinghouse.flat.Flat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class Stage implements Paintable {

    private static final Logger LOGGER = LogManager.getLogger(Stage.class);

    private List<Flat<?>> flats;
    private Boolean isPainted;

    public Stage(List<Flat<?>> flats, Boolean isPainted) {
        this.flats = flats;
        this.isPainted = isPainted;
    }

    public void cleaningStage() {
        LOGGER.debug("The Stage is cleaned");
    }

    public Double stageWallsAreaCalc() {
        Double stageWallsArea = flats
                .stream()
                .map(flat -> flat.flatWallsAreaCalc())
                .reduce((a, e) -> a + e)
                .get();
        LOGGER.debug("\n\nstageWallsArea   \n" + stageWallsArea);
        return stageWallsArea;
    }

//    public double stageWallsAreaCalc() {
//        double stageWallsArea = 0;
//        for (Flat<?> flat : flats) {
//            stageWallsArea += flat.flatWallsAreaCalc();
//        }
//    LOGGER.debug("\n\n stageWallsArea   \n" +  stageWallsArea);
//        return stageWallsArea;
//    }

    public double stageTimeProduceCalc() {
        double stageTimeProduce = flats
                .stream()
                .map(flat -> flat.flatTimeProduceCalc())
                .reduce((a, e) -> a + e)
                .get();

        return stageTimeProduce;
    }

//    public double stageTimeProduceCalc() {
//        double stageTimeProduce = 0;
//        for (Flat<?> flat : flats) {
//            stageTimeProduce += flat.flatTimeProduceCalc();
//        }
//        return stageTimeProduce;
//    }


    public List<Flat<?>> getFlats() {
        return flats;
    }

    public void setFlats(List<Flat<?>> flats) {
        this.flats = flats;
    }

    public Boolean getPainted() {
        return isPainted;
    }

    public void setPainted(Boolean painted) {
        isPainted = painted;
    }

    @Override
    public String toString() {
        return "\n\nThis stage has " + flats.size() + " flats " +
                "\n And It can be produced for " + stageTimeProduceCalc() + " sec " +
                "\nflats=" + flats.toString() +
                ", isPainted=" + isPainted +
                '}';
    }

    @Override
    public String toPaint() {
        if (isPainted) {
            return "     ----  the stage is already painted";
        } else {
            return "     ----  the stage can be painted in any color";
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stage stage = (Stage) o;
        return Objects.equals(flats, stage.flats) && Objects.equals(isPainted, stage.isPainted);
    }

    @Override
    public int hashCode() {
        return Objects.hash(flats, isPainted);
    }
}
