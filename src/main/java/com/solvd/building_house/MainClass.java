package com.solvd.building_house;

import com.solvd.building_house.dom.Address;
import com.solvd.building_house.dom.House;
import com.solvd.building_house.exception.InvalidCountStageException;
import com.solvd.building_house.flat.Flat;
import com.solvd.building_house.room.*;
import com.solvd.building_house.sostav.Element;
import com.solvd.building_house.sostav.ElementMaterial;
import com.solvd.building_house.sostav.Wall;
import com.solvd.building_house.stage.Stage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.solvd.building_house.room.CeilingColor.*;
import static com.solvd.building_house.room.FloorCoverMaterial.*;
import static com.solvd.building_house.sostav.ElementMaterial.*;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {

        LOGGER.debug("Посчитать площадь всех стен в доме, Массивы, Несколько вложенных циклов\n");

        Element<String> elementOne = new Element<>(0.2, 0.1, BRICK, "Gost1");
        Element<Double> elementTwo = new Element<>(5, 2, BETON, 3.14);
        Element<String> elementThree = new Element<>(6, 2, WOODEN, "Gost33");
        Element<Integer> elementFour = new Element<>(4, 2, STEEL, 12345);
        elementThree.printMaterialInfo();

        Map<ElementMaterial, String> elementColorMap = new HashMap<>();
        elementColorMap.put(elementOne.getElementMaterial(), "Red");
        elementColorMap.put(elementTwo.getElementMaterial(), "Grey");
        elementColorMap.put(elementThree.getElementMaterial(), "Green");
        elementColorMap.put(elementFour.getElementMaterial(), "Black");
        System.out.println("\n\nelementColorMap \n " + elementColorMap + "\n");

        List<Element<?>> elements = new ArrayList<>();
        elements.add(elementOne);
        elements.add(elementTwo);
        elements.add(elementThree);
        elements.add(elementFour);
        LOGGER.debug(elements + "\n");

        Wall wallOne = new Wall(elementOne, 200);
        Wall wallTwo = new Wall(elementOne, 250);
        Wall wallThree = new Wall(elementOne, 350);
        Wall wallFour = new Wall(elementOne, 300);
        wallOne.toColor();

        List<Wall> wallsOne = new ArrayList<>();
        wallsOne.add(wallOne);
        wallsOne.add(wallTwo);
        wallsOne.add(wallThree);
        wallsOne.add(wallFour);

        LOGGER.debug("\n");

        Floor floorOne = new Floor(false, WOOD);
        floorOne.turnOn();
        floorOne.floorCoverInfo();
        Ceiling ceilingOne = new Ceiling(true, PINK);
        Room roomOne = new Room(wallsOne, floorOne, ceilingOne, "Bed-room");

        Wall wallFive = new Wall(elementTwo, 1);
        Wall wallSix = new Wall(elementThree, 1);
        Wall wallSeven = new Wall(elementFour, 2);

        List<Wall> wallsTwo = new ArrayList<>();
        wallsTwo.add(wallFive);
        wallsTwo.add(wallSix);
        wallsTwo.add(wallSeven);

        Floor floorTwo = new Floor(true, LAMINAT);
        Ceiling ceilingTwo = new Ceiling(true, WHITE);
        ceilingTwo.toColor();
        Room roomTwo = new Room(wallsTwo, floorTwo, ceilingTwo, "Living-room");
        LOGGER.debug(roomTwo.toPaint());

        List<Room> roomsOne = new ArrayList<>();
        roomsOne.add(roomOne);
        roomsOne.add(roomTwo);

        Flat<String> flatOne = new Flat<>(roomsOne, "Green");

        LOGGER.debug("\n\n");

        Wall wallEight = new Wall(elementOne, 1000);
        Wall wallNine = new Wall(elementFour, 2);
        List<Wall> wallsThree = new ArrayList<>();
        wallsThree.add(wallEight);
        wallsThree.add(wallNine);

        Floor floorThree = new Floor(false, LENOLEUM);
        Ceiling ceilingThree = new Ceiling(true, GREEN);
        Room room3 = new Room(wallsThree, floorThree, ceilingThree, "Dinning-room");
        floorThree.floorCoverInfo();

        List<Room> roomsTwo = new ArrayList<>();
        roomsTwo.add(room3);
        Flat<String> flatTwo = new Flat<>(roomsTwo, "Brown");

        List<Flat<?>> flatsOne = new ArrayList<>();
        flatsOne.add(flatOne);
        flatsOne.add(flatTwo);

        Map<Flat<String>, List<Room>> flatRooms = new HashMap<>();
        flatRooms.put(flatOne, roomsOne);
        flatRooms.put(flatTwo, roomsTwo);
        LOGGER.debug("\n\n flatRooms\n" + flatRooms);


        Stage stage = new Stage(flatsOne, true);
        LOGGER.debug(stage.toPaint());

        LOGGER.debug("\n\nPolymorphism is here\n");
        Polymorphism test = new Polymorphism();
        LOGGER.debug(" floorThree " + floorThree);
        test.floorHeating(floorThree, floorThree.getHeated());
        LOGGER.debug(" floorTwo " + floorTwo);
        test.floorHeating(floorTwo, floorTwo.getHeated());

        LOGGER.debug("\n\n");

        Address address = Address.getInstance();
        address.setCity("Minsk");
        address.setStreet("Zhukov");
        address.setHouseNumber(18);

//        House<Boolean> houseOne = null;
        House<String> houseTwo = null;
        try {
//            houseOne = new House<>("Round", "Liveable", stage, 3, address, false);
            houseTwo = new House<>("Round", "Liveable", stage, 1, address, "NO");
        } catch (InvalidCountStageException e) {
            LOGGER.debug("Incorrect number of (count)Stages.  " + e.getLocalizedMessage(), e);
        } catch (Exception e) {
            LOGGER.debug("Other exception");
        } finally {
            LOGGER.debug("End of setting the house");
        }
        try (ConnectionResource resource = new ConnectionResource()) {
            LOGGER.debug("Do smth in 'try block'");
        }

        LOGGER.debug("        -----       -----        ----           ");

        assert houseTwo != null;
        houseTwo.printFurnitureInfo();

        LOGGER.debug(houseTwo.toString());

        LOGGER.debug("        -----       -----        ----           ");

        roomTwo.printRoomInfo(elementOne.getElementMaterial().toString() + " and it is " + elementOne.getElementMaterial().getDescription());

        LOGGER.debug("\n");
        ceilingOne.printCeilInfo();
        ceilingTwo.printCeilInfo(true);

    }
}
