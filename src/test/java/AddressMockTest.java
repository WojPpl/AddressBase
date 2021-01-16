import AddressBase.Address;

import org.junit.After;
import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class AddressMockTest {

    Address Address;

    @Before
    public void setup() {
        Address = new Address();
        Address mockAddress1 = Mockito.mock(Address.class);
        Address mockAddress2 = Mockito.mock(Address.class);
        List<Address> ListOfAddresses = new ArrayList<>();
        ListOfAddresses.add(mockAddress1);
        ListOfAddresses.add(mockAddress2);
        Address.setAdditionalAddresses(ListOfAddresses);
        when(mockAddress1.getName()).thenReturn("Marian");
        when(mockAddress1.getSurname()).thenReturn("Zielony");
        when(mockAddress2.getName()).thenReturn("Elvis");
        when(mockAddress2.showFullName()).thenReturn("Elvis Presley");
        when(mockAddress1.getEmail()).thenReturn("marian@zielony.pl");
        when(mockAddress2.getEmail()).thenReturn("elvis.pl");
        when(mockAddress1.getStreet()).thenReturn("Sezamkowa 11");
        when(mockAddress2.getStreet()).thenReturn("");
        when(mockAddress1.getPostcode()).thenReturn("88-241");
        when(mockAddress2.getPostcode()).thenReturn("44-F12");
    }

    @After
    public void clear() {
        Address.clearAll();
    }

    @Test
    public void checkNumberOfAdditionalAddresses() {
        assertEquals(Address.getAdditionalAddresses().size(), 2);
    }

    @Test
    public void checkAdditionalAddressesName() {
        int listIndex = 0;
        List<Address> mockAddressList = Address.getAdditionalAddresses();

        for (AddressBase.Address address : mockAddressList) {
         //   System.out.println(address.getName());
            if(listIndex == 0) {
                assertEquals("Marian", address.getName());
            }
            else {
                assertEquals("Elvis", address.getName());
            }
            listIndex++;
        }
    }

    @Test
    public void checkSecondAdditionalAddressFullName() {
        int listIndex = 0;
        List<Address> mockAddressList = Address.getAdditionalAddresses();
        for (AddressBase.Address address : mockAddressList) {
            if(listIndex != 0) {
                assertEquals("Elvis Presley", address.showFullName());
            }
            listIndex++;
        }
    }

    @Test
    public void checkIfEmailIsValid() {
        int listIndex = 0;
        List<Address> mockAddressList = Address.getAdditionalAddresses();
        for (AddressBase.Address address : mockAddressList) {
            if(listIndex == 0) {
                assertTrue(address.getEmail().contains("@"));
                assertTrue(address.getEmail().contains("."));
            }
            listIndex++;
        }
    }

    @Test
    public void checkIfEmailIsInvalid() {
        int listIndex = 0;
        List<Address> mockAddressList = Address.getAdditionalAddresses();
        for (AddressBase.Address address : mockAddressList) {
            if(listIndex != 0) {
                assertFalse(address.getEmail().contains("@"));
            }
            listIndex++;
        }
    }

    @Test
    public void checkIfAdditionalAddressesAreDifferent() {
        int listIndex = 0;
        String street = "";
        String postalCode = "";
        List<Address> mockAddressList = Address.getAdditionalAddresses();
        for (AddressBase.Address address : mockAddressList) {
            if(listIndex == 0) {
                street = address.getStreet();
                postalCode = address.getPostcode();
            }
            else {
                assertNotSame(street, address.getStreet());
                assertNotSame(postalCode, address.getPostcode());
            }
            listIndex++;
        }
    }

    @Test
    public void checkAdditionalAddressesPostalCodes() {
        List<Address> mockAddressList = Address.getAdditionalAddresses();
        for (AddressBase.Address address : mockAddressList) {
            assertEquals(6, address.getPostcode().length());
            assertTrue(address.getPostcode().contains("-"));
            assertTrue(address.getPostcode().split("-")[0].chars().allMatch(Character::isDigit));
            assertTrue(address.getPostcode().split("-")[1].chars().allMatch(Character::isDigit));
        }
    }

}
