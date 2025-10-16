package com.example.listycity;

/**
 * This is a class that defines a City.
 * A City has a city name and a province/state name.
 * It implements Comparable so City objects can be sorted by city name.
 */
public class City implements Comparable<City> {

    /** City name, e.g., "Edmonton". */
    private String city;

    /** Province/state name, e.g., "Alberta". */
    private String province;

    /**
     * Construct a new City.
     * @param city the city name
     * @param province the province/state name
     */
    City(String city, String province){
        this.city = city;
        this.province = province;
    }

    /** @return the city name */
    String getCityName(){
        return this.city;
    }

    /** @return the province/state name */
    String getProvinceName(){
        return this.province;
    }

    /** Compare by city name (lexicographic). */
    @Override
    public int compareTo(City other) {
        return this.city.compareTo(other.getCityName());
    }
}
