package com.solvd.hw007;

import com.solvd.hw007.dom.House;
import com.solvd.hw007.exception.InvalidAddressException;
import com.solvd.hw007.exception.InvalidCountStageException;
import com.solvd.hw007.flat.Flat;
import com.solvd.hw007.room.Ceiling;
import com.solvd.hw007.room.Floor;
import com.solvd.hw007.room.Room;
import com.solvd.hw007.sostav.Element;
import com.solvd.hw007.sostav.Wall;
import com.solvd.hw007.stage.Stage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) {

        LOGGER.debug("Hello second try");
        LOGGER.debug("Hello. B1 check");
        LOGGER.debug("Посчитать площадь всех стен в доме, Массивы, Несколько вложенных циклов\n");

        Element<String> elementOne = new Element<>(0.2, 0.1, "Brick", "Gost1");
        Element<Double> elementTwo = new Element<>(5, 2, "Beton", 3.14);
        Element<String> elementThree = new Element<>(6, 2, "Cement", "Gost33");
        Element<Integer> elementFour = new Element<>(4, 2, "Steel", 12345);
        elementOne.printMaterialInfo();

        Map<String, String> elementColorMap = new HashMap<>();
        elementColorMap.put(elementOne.getMaterial(), "Red");
        elementColorMap.put(elementTwo.getMaterial(), "Grey");
        elementColorMap.put(elementThree.getMaterial(), "Green");
        elementColorMap.put(elementFour.getMaterial(), "Black");
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

        Floor floorOne = new Floor("wood", false);
        floorOne.turnOn();
        Ceiling ceilingOne = new Ceiling(true, "Pink");
        Room roomOne = new Room(wallsOne, floorOne, ceilingOne, "Bed-room");

        Wall wallFive = new Wall(elementTwo, 1);
        Wall wallSix = new Wall(elementThree, 1);
        Wall wallSeven = new Wall(elementFour, 2);

        List<Wall> wallsTwo = new ArrayList<>();
        wallsTwo.add(wallFive);
        wallsTwo.add(wallSix);
        wallsTwo.add(wallSeven);

        Floor floorTwo = new Floor("Laminat", true);
        Ceiling ceilingTwo = new Ceiling(true, "white");
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

        Floor floorThree = new Floor("Lenoleum", false);
        Ceiling ceilingThree = new Ceiling(true, "Yellow");
        Room room3 = new Room(wallsThree, floorThree, ceilingThree, "Dinning-room");

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

//        House<Boolean> houseOne = null;
        House<String> house = null;
        try {
//            houseOne = new House<>("Round", "Liveable", stage, 3, "Brest, Center", false);
            house = new House<>("Round", "Liveable", stage, 1, "Minsk, Center", "NO");
        } catch (InvalidCountStageException | InvalidAddressException e) {
            LOGGER.debug("Incorrect number of (count)Stages or Address name.  " + e.getLocalizedMessage(), e);
        } catch (Exception e) {
            LOGGER.debug("Other exception");
        } finally {
            LOGGER.debug("End of setting the house");
        }
        try (ConnectionResource resource = new ConnectionResource()) {
            LOGGER.debug("Do smth in 'try block'");
        }

        LOGGER.debug("        -----       -----        ----           ");

        assert house != null;
        house.printFurnitureInfo();

        LOGGER.debug(house.toString());

        LOGGER.debug("        -----       -----        ----           ");

        LOGGER.debug("\n");
        roomOne.printRoomInfo();
        roomTwo.printRoomInfo(elementOne.getMaterial());

        LOGGER.debug("\n");
        ceilingOne.printCeilInfo();
        ceilingTwo.printCeilInfo(true);

    }
}
