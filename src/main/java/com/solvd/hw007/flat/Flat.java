package com.solvd.hw007.flat;

import com.solvd.hw007.Electrisized;
import com.solvd.hw007.room.Room;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Objects;


public class Flat<T> implements Electrisized {

    private static final Logger LOGGER = LogManager.getLogger(Flat.class);

    private List<Room> rooms;
    private T color;

    public Flat(List<Room> rooms, T color) {
        this.rooms = rooms;
        this.color = color;
    }

    public double flatWallsAreaCalc() {
        double flatWallsArea = 0;
        for (Room room : rooms) {
            flatWallsArea += room.roomWallsAreaCalc();
        }
        return flatWallsArea;
    }

    public double flatTimeProduceCalc() {
        double flatTimeProduce = 0;
        for (Room room : rooms) {
            flatTimeProduce += room.roomTimeProduceCalc();
        }
        return flatTimeProduce;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public T getColor() {
        return color;
    }

    public void setColor(T color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "\n\n  " +
                "\nThis Flat's color='" + color + '\'' +
                "\nThis flat walls area is - " + flatWallsAreaCalc() + "m2" +
                "\nAnd it can be produced for " + flatTimeProduceCalc() + "seconds" +
                "\nIt has " + rooms.size() + " rooms " +
                "\n,rooms=" + rooms.toString() +
                '}';
    }

    @Override
    public String toElectrisize() {
        String elecrto = "\n\nWe do have electricity in this flat";
        LOGGER.debug(elecrto);
        return elecrto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flat<?> flat = (Flat<?>) o;
        return Objects.equals(rooms, flat.rooms);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rooms);
    }
}
