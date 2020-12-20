import AddressBase.Address;
import static org.junit.Assert.*;
import static org.junit.Assert.assertNotSame;

import AddressBase.CityException;
import org.json.simple.JSONObject;
import org.junit.After;
import org.junit.Before;

import org.junit.jupiter.api.Test;

public class AddressTest {
    Address testAddress1 = new Address("Marian", "Zielony", "Sezamkowa 11", "Zakopane", "Bajdocja", "44556784", "88-241", "marian@zielony.pl");;
    Address testAddress2 = new Address("Elvis", "Presley", "", "Las Wegas", "", "445556F784", "44-F12", "elvis@elvisp.pl");


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
            check = true;
        }
        catch (CityException e ) {
            System.out.println("Wpisane miasto zawiera liczbę " + e.geNumericCity());
            check = false;
        }
        assertFalse(check);
    }
    //nowe
    @Test
    void checkFullNamePrint() {
        assertEquals("Marian Zielony", testAddress1.showFullName());
        assertEquals("Elvis Presley", testAddress2.showFullName());
    }

    @Test
    void checkIfFullNameIsValid() {
        assertTrue(testAddress1.showFullName().contains(" "));
        assertTrue(testAddress2.showFullName().contains(" "));
    }

    @Test
    void checkFullAddressPrint() {
        assertEquals("Sezamkowa 11 88-241 Zakopane,Bajdocja", testAddress1.showFullName());
        assertEquals("44-F12 Las Wegas,", testAddress2.showFullName());
    }

    @Test
    void postCodeValidation() {
        assertTrue(testAddress1.getPostcode().contains("-"));
        assertTrue(testAddress2.getPostcode().contains("-"));
        assertTrue(testAddress1.getPostcode().split("-")[0].chars().allMatch(Character::isDigit));
        assertTrue(testAddress2.getPostcode().split("-")[0].chars().allMatch(Character::isDigit));
    }

    @Test
    void streetValidation() {
        assertTrue(testAddress1.getStreet().contains(" "));
        assertTrue(testAddress2.getStreet().contains(" "));
        assertTrue(testAddress1.getPostcode().split(" ")[1].chars().allMatch(Character::isDigit));
        assertTrue(testAddress2.getPostcode().split(" ")[1].chars().allMatch(Character::isDigit));
    }

    @Test
    void emailValidation() {
        assertTrue(testAddress1.getEmail().contains("@"));
        assertTrue(testAddress2.getEmail().contains("@"));
        assertTrue(testAddress1.getEmail().contains("."));
        assertTrue(testAddress2.getEmail().contains("."));
    }

    @Test
    void addressToJsonValidation() {
        JSONObject testJson = new JSONObject();
        testJson = testAddress1.addressToJson();
        assertEquals("{\"country\":\"Bajdocja\",\"city\":\"Zakopane\",\"phone\":\"44556784\",\"surname\":\"Zielony\",\"street\":\"Sezamkowa 11\",\"name\":\"Marian\",\"postcode\":\"88-241\",\"email\":\"marian@zielony.pl\"}", testJson.toJSONString());
    }

    @Test
    void addressFromJsonValidation() {
        assertEquals("Marian", testAddress1.addressFromJson(testAddress1.addressToJson()).getName());
    }

    @Test
    void addressIOException() {
        JSONObject testJson = new JSONObject();
        assertNull(testJson.toJSONString());
    }

    @Test
    void checkFullAddressIsValid() {
       assertEquals(testAddress1.getStreet()+" "+testAddress1.getPostcode()+" "+testAddress1.getCity()+","+testAddress1.getCountry(),"Sezamkowa 11 88-241 Zakopane,Bajdocja", testAddress1.showFullAddress());
    }

}
