package com.solvd.hw007.dom;

import com.solvd.hw007.exception.InvalidAddressException;

/**
 * Singleton realisation
 */
public class Address {

    private static Address instance;

    private String city;
    private String street;
    private int houseNumber;

    private Address() {
    }

    public static Address getInstance() {
        if (instance == null) {
            instance = new Address();

        }
        return instance;
    }

    public void setCity(String city) throws InvalidAddressException {
        if (city.contains("_")) {
            throw new InvalidAddressException("City cannot contain '_' symbol");
        }
        this.city = city;
    }

    public void setStreet(String street) {
        if (street.isEmpty()) {
            throw new InvalidAddressException("Street must have name");
        }
        this.street = street;
    }

    public void setHouseNumber(int houseNumber) {
        if (houseNumber == 0 || houseNumber > 5000) {
            throw new InvalidAddressException("Number Of house must be real");
        }
        this.houseNumber = houseNumber;
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
