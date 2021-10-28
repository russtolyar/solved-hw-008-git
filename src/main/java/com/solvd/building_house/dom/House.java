package com.solvd.building_house.dom;

import com.solvd.building_house.exception.InvalidCountStageException;
import com.solvd.building_house.stage.Stage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.Objects;

public class House<T> extends Building {

    private static final Logger LOGGER = LogManager.getLogger(House.class);

    static {
        LOGGER.debug("New house has been created");
    }

    private Stage stage;
    private int countStages;
    private Address address;

    private final T hasFurniture;

    public House(String form, String type, Stage stage,
                 int countStages, Address address, T hasFurniture) throws InvalidCountStageException {
        super(form, type);
        this.stage = stage;
        if (countStages <= 0) {
            throw new InvalidCountStageException("Count of stages must be natural");
        }
        this.countStages = countStages;

        this.hasFurniture = hasFurniture;
    }

    public double houseWallsAreaCalc() {
        return stage.stageWallsAreaCalc() * countStages;
    }

    public long houseTimeProduceCalc() {
        LocalDateTime startBuild = LocalDateTime.now();
        LOGGER.debug("If we start building - " + startBuild);
        long time = (long) stage.stageTimeProduceCalc() * countStages;
        LOGGER.debug("We need " + time + " seconds to build this house!");
        int days = (int) (time / 3600 / 24);
        int hour = (int) (time / 3600 % 24);
        int min = (int) (time / 60 % 60);
        int sec = (int) (time % 60);
        String timeToBuild = String.format("%s days %s:%s:%s", days, hour, min, sec);
        LOGGER.debug(timeToBuild);
        LocalDateTime finishBuild = LocalDateTime.now().plusSeconds(time);
        LOGGER.debug("The building will be finished at " + finishBuild);
        return time;
    }

    public void printFurnitureInfo() {
        LOGGER.debug("As to furniture, this house has it. -" + hasFurniture);
    }

    @Override
    public void printBuildingType() {
        LOGGER.debug("This is " + getType());
    }

    @Override
    public void printConstrForm() {
        LOGGER.debug("Form of Construction is " + getForm());
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public int getCountStages() {
        return countStages;
    }

    public void setCountStages(int countStages) throws InvalidCountStageException {
        if (countStages <= 0) {
            throw new InvalidCountStageException("Count of stages must be natural");
        }
        this.countStages = countStages;
    }

    public Address getAddress() {
        return address;
    }


    @Override

    public String toString() {
        return "\n\n        -----       -----        ----           " +
                "\nThis House's address is \n" + Address.getInstance().getCity() +
                "\n" + Address.getInstance().getStreet() + "\n" + Address.getInstance().getHouseNumber() +
                '\'' + ",\n It has " + countStages + " Stages," +
                "\nThis house walls Total area is " + houseWallsAreaCalc() + "m2" +
                "\n Building time - " + houseTimeProduceCalc() + " sek" +
                "\n has this house Furniture ? - " + hasFurniture +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        House<?> house = (House<?>) o;
        return countStages == house.countStages
                && Objects.equals(stage, house.stage)
                && Objects.equals(address, house.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stage, countStages, address);

    }
}
