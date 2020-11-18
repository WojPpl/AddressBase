package AddressBase;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotSame;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

class AddressTest {
    Address testAddress1 = new Address("Marian", "Zielony", "Sezamkowa 11", "Łysa Góra", "Bajdocja", "44556784", "88-241");;
    Address testAddress2 = new Address("Elvis", "Presley", "", "Las Wegas", "", "445556F784", "44-F12");

    @Before
    public void setup() {
    }

    @After
    public void clear() {
        testAddress1.clearAll();
        testAddress2.clearAll();
    }

    @Test
    void postalCodesLength() {
        //System.out.println(testAddress1.getPostcode().length());
        assertEquals(6, testAddress1.getPostcode().length());
        assertEquals(6, testAddress2.getPostcode().length());
    }

    @Test
    void phoneIsNumeric() {
        assertTrue(testAddress1.getPhone().chars().allMatch(Character::isDigit));
    }

    @Test
    void phoneIsNumericFail() {
        assertFalse(testAddress2.getPhone().chars().allMatch(Character::isDigit));
    }

    @Test
    void addressIsDifferent() {
        assertNotSame(testAddress1.getCity() + testAddress1.getStreet(), testAddress2.getCity() + testAddress2.getCity());
    }

    @Test
    void checkException() {
        Boolean check;
        try {
            testAddress1.setCity("123");
            check = false;
        }
        catch (CityException e ) {
            System.out.println("Wpisane miasto zawiera liczbę " + e.geNumericCity());
            check = true;
        }
        assertNotEquals(false, check);
    }
}
