package AddressBase;

public class Address {

    protected String Name;
    protected String Surname;
    protected String Street;
    protected String City;
    protected String Country;
    protected String Phone;
    protected String Postcode;

    public Address() {
    }

    public Address(String name, String surname, String street, String city, String country, String phone, String postcode) {
        this();
        this.Name = name;
        this.Surname = surname;
        this.Street = street;
        this.City = city;
        this.Country = country;
        this.Phone = phone;
        this.Postcode = postcode;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) throws CityException {
        if (city.chars().allMatch(Character::isAlphabetic)) {
            City = city;
        }
        else {
            throw new CityException(city);
        }
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPostcode() {
        return Postcode;
    }

    public void setPostcode(String postcode) {
        Postcode = postcode;
    }

    public void clearAll() {
        this.setName("");
        this.setSurname("");
        try {
        this.setCity(""); }
        catch (CityException e ) {
            System.out.println("Wpisane miasto zawiera liczbę :" + e.geNumericCity());
        };
        this.setStreet("");
        this.setPostcode("");
        this.setCountry("");
        this.setPhone(null);
    }

    public void showAddress() {
        System.out.println("===================================================");
        System.out.println(this.getName() + " " + this.getSurname());
        System.out.println(this.getStreet());
        System.out.println(this.getPostcode() + " " + this.getCity());
        System.out.println(this.getCountry());
        System.out.println(this.getPhone());
        System.out.println("===================================================");
    }
}
