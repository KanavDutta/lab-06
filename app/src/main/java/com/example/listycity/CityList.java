package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps track of a list of city objects.
 */
public class CityList {

    private final List<City> cities = new ArrayList<>();

    /**
     * Add a city if it does not already exist.
     * @param city candidate city
     * @throws IllegalArgumentException if the city already exists
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }

    /**
     * @return a new list of cities sorted by city name
     */
    public List<City> getCities() {
        List<City> list = new ArrayList<>(cities);
        Collections.sort(list);
        return list;
    }

    // ---- Extra methods for Lab 6 ----

    /**
     * @param city city to check
     * @return true if the city exists in the list
     */
    public boolean hasCity(City city) {
        return cities.contains(city);
    }

    /**
     * Remove a city if present; otherwise throw.
     * @param city city to remove
     * @throws IllegalArgumentException if the city is not present
     */
    public void delete(City city) {
        if (!cities.remove(city)) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * @return number of cities in the list
     */
    public int countCities() {
        return cities.size();
    }
}
