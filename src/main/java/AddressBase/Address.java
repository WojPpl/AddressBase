package AddressBase;
import org.json.simple.JSONObject;

public class Address {

    protected String Name;
    protected String Surname;
    protected String Street;
    protected String City;
    protected String Country;
    protected String Phone;
    protected String Postcode;
    protected String Email;


    public Address() {
    }

    public Address(String name, String surname, String street, String city, String country, String phone, String postcode, String email) {
        this();
        this.Name = name;
        this.Surname = surname;
        this.Street = street;
        this.City = city;
        this.Country = country;
        this.Phone = phone;
        this.Postcode = postcode;
        this.Email = email; //nowe pole
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

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
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
    // nowe funkcjonalności

    public void showFullName() {
        System.out.println(
                this.getName() + " " + this.getSurname()
        );
    }

    public void showFullAddress() {
        System.out.println(this.getStreet() + " " + this.getPostcode() + " " + this.getCity() + "," + this.getCountry());
    }

    public void addressToJson() {
        JSONObject json = new JSONObject();
        json.put("name","foo");
        json.put("num",new Integer(100));
        json.put("balance",new Double(1000.21));
        json.put("is_vip",new Boolean(true));
        json.put("nickname",null);
        System.out.print(json);
    }

    public Address addressFromJson(JSONObject address) {
        Address addressFromJson = new Address();
        return addressFromJson;
    }


}
