
package com.solvd.buildinghouse;

import com.solvd.buildinghouse.dom.Address;
import com.solvd.buildinghouse.dom.House;
import com.solvd.buildinghouse.exception.InvalidCountStageException;
import com.solvd.buildinghouse.exception.InvalidElementHeightException;
import com.solvd.buildinghouse.flat.Flat;
import com.solvd.buildinghouse.room.*;
import com.solvd.buildinghouse.sostav.Element;
import com.solvd.buildinghouse.sostav.ElementMaterial;
import com.solvd.buildinghouse.sostav.Wall;
import com.solvd.buildinghouse.stage.Stage;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.*;
import java.util.*;
import java.util.stream.Collectors;

import static com.solvd.buildinghouse.room.CeilingColor.*;
import static com.solvd.buildinghouse.room.FloorCoverMaterial.*;
import static com.solvd.buildinghouse.sostav.ElementMaterial.*;


public class MainClass {

    private static final Logger LOGGER = LogManager.getLogger(MainClass.class);

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, InstantiationException {

        LOGGER.debug("Посчитать площадь всех стен в доме, Массивы, Несколько вложенных циклов\n");

        LOGGER.debug("Reflection is here\n");

        Element<String> elementReflection = new Element<>(8, 2, WOODEN, "Gost100");
        LOGGER.debug(elementReflection + "\n");

        elementReflection.checkEnums(elementReflection.printEnumList(), (ElementMaterial em) -> {
            System.out.println("LAMBDA is used here");

            return em.toString().length() <= 5;

        });

//        Class<?> elementClass = null;
//        try {
//            elementClass = Class.forName("com.solvd.building_house.sostav.Element");
//        } catch
//        (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

        //Получаем класс класса Element
        Class<Element> elementClass = Element.class;
        // Определяем типы переменных параметров для параметризованных методов построения
        Class[] parType = new Class[]{double.class, double.class, ElementMaterial.class, Object.class};
        // Создание класса конструктора по параметрам
        Constructor<Element> constr = elementClass.getConstructor(parType);
        // Передаем соответствующие параметры для конструктора с параметрами
        Object[] objElement = new Object[]{
                10,
                2.6,
                BETON,
                "NewGost"
        };
//         Создать экземпляр класса Element с помощью метода newInstance.
        Object objectElement = constr.newInstance(objElement);
        LOGGER.debug(objectElement);

        LOGGER.debug("\n\n!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!\n\n");

        Arrays.stream(elementClass.getDeclaredFields()).forEach(System.out::println);

//        Field[] declaredFields = elementClass.getDeclaredFields();
//        for (Field field : declaredFields) {
//            LOGGER.debug(field);
//        }

        Field heightField = elementClass.getDeclaredField("height");
        heightField.setAccessible(true);
        LOGGER.debug("\nBefore change the height was " + heightField.get(elementReflection));
        heightField.setDouble(elementReflection, 2.5);
        LOGGER.debug("\nAfter change the height is " + heightField.get(elementReflection));

        Field elementMaterialField = elementClass.getDeclaredField("elementMaterial");
        elementMaterialField.setAccessible(true);

        LOGGER.debug("\nBefore change the ElementMaterial was " + elementMaterialField.get(elementReflection));
        elementMaterialField.set(elementReflection, BETON);
        LOGGER.debug("\nAfter change the ElementMaterial is " + elementMaterialField.get(elementReflection));

        Arrays.stream(elementClass.getDeclaredMethods()).forEach(System.out::println);

//        Method[] myDeclaredMethods = elementClass.getDeclaredMethods();
//        for (Method method : myDeclaredMethods) {
//            LOGGER.debug(method);
//      }

        Method getPrintEnumListMethod = elementClass.getDeclaredMethod("printEnumList");
        int modifiers0 = getPrintEnumListMethod.getModifiers();
        LOGGER.debug(" is this method " + getPrintEnumListMethod.getName() + " public? - " + Modifier.isPublic(modifiers0));
        LOGGER.debug(" is this method " + getPrintEnumListMethod.getName() + " final? - " + Modifier.isFinal(modifiers0));
        LOGGER.debug("\n\n" + getPrintEnumListMethod.invoke(elementReflection) + "\n");

        Method getToStringMethod = elementClass.getDeclaredMethod("toString");
        int modifiers1 = getToStringMethod.getModifiers();
        LOGGER.debug(" is this method " + getToStringMethod.getName() + " public? - " + Modifier.isPublic(modifiers1));
        LOGGER.debug(" is this method " + getToStringMethod.getName() + " final? - " + Modifier.isFinal(modifiers1));
        LOGGER.debug("\n\n" + getToStringMethod.invoke(elementReflection) + "\n");

        Method getPrintMaterialInfoMethod = elementClass.getMethod("printMaterialInfo");
        int modifiers = getPrintMaterialInfoMethod.getModifiers();
        LOGGER.debug(" is this method " + getPrintMaterialInfoMethod.getName() + " public? - " + Modifier.isPublic(modifiers));
        LOGGER.debug(" is this method " + getPrintMaterialInfoMethod.getName() + " final? - " + Modifier.isFinal(modifiers));

        getPrintMaterialInfoMethod.invoke(elementReflection);

        LOGGER.debug("\n\nThe end of reflection\n\n");

        Element<String> elementOne = new Element<>(0.2, 0.1, BRICK, "Gost1");
        Element<Double> elementTwo = new Element<>(5, 2, BETON, 3.14);
        Element<String> elementThree = new Element<>(6, 2.2, WOODEN, "Gost33");
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

        List<Element<?>> filterElementsList = elements
                .stream()
                .filter(e -> e.getLength() > 4.3)
                .collect(Collectors.toList());
        LOGGER.debug("\n\nfilterElementsList - \n" + filterElementsList);

        Optional<?> findFirstElementB = elements
                .stream()
                .filter(element -> element
                        .getElementMaterial()
                        .toString()
                        .startsWith("B"))
                .findFirst();
        LOGGER.debug("\n\nfindFirstElementB - \n" + findFirstElementB);

        List<Double> mapSquareElement = elements
                .stream()
                .map(element -> element
                        .getHeight() * element
                        .getLength())
                .collect(Collectors.toList());
        LOGGER.debug("\n\nmapSquareElement - \n" + mapSquareElement);

        Element<?> orElseFindAnyElements = elements
                .stream()
                .filter(element -> element
                        .getElementMaterial() == WOODEN)
                .findAny()
                .orElse(elementReflection);
        LOGGER.debug("\n\norElseFindAnyElements - \n" + orElseFindAnyElements);

        LOGGER.debug(elements);
        Element<?> orElseThrowElements = elements
                .stream()
                .filter(element -> element
                        .getHeight() < 7 && element.getHeight() >= 0)
                .findFirst()
                .orElseThrow(InvalidElementHeightException::new);
        LOGGER.debug("\n\norElseThrowElements - \n" + orElseThrowElements);

        List<Element<?>> peekDoubledHeightElementsList = elements
                .stream()
                .peek(e -> e.setHeight(e.getHeight() * 2))
                .collect(Collectors.toList());
        LOGGER.debug("\n\npeekDoubledHeightElementsList - \n" + peekDoubledHeightElementsList);

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

        List<Room> flatMapElements = flatsOne
                .stream()
                .flatMap(flat -> flat.getRooms().stream())
                .peek(room -> room.getWalls().stream().
                                filter(wall -> wall.getElement().getHeight() > 2))
                .collect(Collectors.toList());
        LOGGER.debug("\n\n flatMapElements\n" + flatMapElements + "\n\n");

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
