package AddressBase;

public class CityException extends Exception {
    private String numbersInCityName;

    public CityException(String numberInCityName) {
        this.numbersInCityName = numberInCityName;
    }

    public String geNumericCity() {
        return numbersInCityName;
    }
}
