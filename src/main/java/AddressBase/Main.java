package AddressBase;

import org.json.simple.parser.ParseException;

public class Main {

    public static void main(String[] args) throws ParseException {
        Address testAddress = new Address("Marian","Zielony","Sezamkowa 11","Zakopane","Bajdocja","445556784","88-241", "marian@zielony.pl");
        testAddress.showAddress();
        System.out.println(testAddress.showFullName());
        System.out.println(testAddress.addressFromJson(testAddress.addressToJson()).showFullAddress());
    }
}