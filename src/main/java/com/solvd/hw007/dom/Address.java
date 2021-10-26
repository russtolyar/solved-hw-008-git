package com.solvd.hw007.dom;

/**
 * Singleton realisation
 */
public class Address {

    private static Address instance;
    private static String city = "Minsk";
    private static String street = "Zhukov";
    private static int houseNumber = 18;

    private Address() {
    }

    public static Address getInstance() {
        if (instance == null) {
            instance = new Address();
        }
        return instance;
    }

    public String getCity() {
        return city;
    }


    public String getStreet() {
        return street;
    }


    public int getHouseNumber() {
        return houseNumber;
    }

}
