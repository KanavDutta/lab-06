package com.example.listycity;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CityListTest {

    // --- Helpers -------------------------------------------------------------

    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity()); // adds "Edmonton, Alberta"
        return cityList;
    }

    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    // --- add() ---------------------------------------------------------------

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());

        City regina = new City("Regina", "Saskatchewan");
        cityList.add(regina);

        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(regina));
    }

    @Test
    void testAddException_whenAddingDuplicateInstance() {
        CityList cityList = mockCityList();
        City dup = mockCity(); // NOTE: different instance with same fields is NOT duplicate unless equals() is overridden
        cityList.add(dup);     // allowed because City doesn't override equals/hashCode by default

        // Adding the same *instance* again should throw (list already contains 'dup')
        assertThrows(IllegalArgumentException.class, () -> cityList.add(dup));
    }

    // --- getCities() sorting -------------------------------------------------

    @Test
    void testGetCities_sortedByCityName() {
        CityList cityList = mockCityList();

        // Initially just Edmonton
        List<City> initial = cityList.getCities();
        assertEquals(1, initial.size());
        assertEquals(0, mockCity().compareTo(initial.get(0))); // same name as Edmonton

        // Add a city that sorts before Edmonton
        City charlottetown = new City("Charlottetown", "Prince Edward Island");
        cityList.add(charlottetown);

        List<City> sorted = cityList.getCities();
        assertEquals(2, sorted.size());
        // Order: Charlottetown, Edmonton
        assertEquals(0, charlottetown.compareTo(sorted.get(0)));
        assertEquals(0, mockCity().compareTo(sorted.get(1)));
    }

    // --- hasCity() -----------------------------------------------------------

    @Test
    void testHasCity() {
        CityList cityList = mockCityList();
        City edmonton = mockCity();

        // Because City does not override equals(), contains() matches by instance.
        // The list contains a different Edmonton instance than 'edmonton', so:
        assertFalse(cityList.hasCity(edmonton));

        // Add this exact instance, then it should be found
        cityList.add(edmonton);
        assertTrue(cityList.hasCity(edmonton));
    }

    // --- delete() ------------------------------------------------------------

    @Test
    void testDelete_removesWhenPresent() {
        CityList cityList = new CityList();
        City calgary = new City("Calgary", "Alberta");
        cityList.add(calgary);

        assertTrue(cityList.hasCity(calgary));
        cityList.delete(calgary);
        assertFalse(cityList.hasCity(calgary));
    }

    @Test
    void testDelete_throwsWhenAbsent() {
        CityList cityList = mockCityList();
        City notInList = new City("Toronto", "Ontario");

        assertFalse(cityList.hasCity(notInList));
        assertThrows(IllegalArgumentException.class, () -> cityList.delete(notInList));
    }

    // --- countCities() -------------------------------------------------------

    @Test
    void testCountCities() {
        CityList cityList = new CityList();
        assertEquals(0, cityList.countCities());

        City a = new City("Airdrie", "Alberta");
        City b = new City("Banff", "Alberta");

        cityList.add(a);
        assertEquals(1, cityList.countCities());

        cityList.add(b);
        assertEquals(2, cityList.countCities());

        cityList.delete(a);
        assertEquals(1, cityList.countCities());
    }
}
