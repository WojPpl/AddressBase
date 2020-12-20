package AddressBase;

public class Main {

    public static void main(String[] args) {
        Address testAddress = new Address("Marian","Zielony","Sezamkowa 11","Łysa Góra","Bajdocja","445556784","88-241", "marian@zielony.pl");
        testAddress.showAddress();
        testAddress.showFullAddress();
        testAddress.showFullName();
        testAddress.addressToJson();
    }
}