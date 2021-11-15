package esgi.barrie.al.model.user;

import esgi.barrie.al.model.validators.user.AddressValidator;

import java.util.Objects;

public class Address {
    private String streetNumber;
    private String streetName;
    private String zipCode;
    private String city;
    private String country;

    private Address(String streetNumber, String streetName, String zipCode, String city, String country) {
        this.streetNumber = Objects.requireNonNull(streetNumber);
        this.streetName = Objects.requireNonNull(streetName);
        this.zipCode = Objects.requireNonNull(zipCode);
        this.city = Objects.requireNonNull(city);
        this.country = Objects.requireNonNull(country);
    }

    public static Address of(String streetNumber, String streetName, String zipCode, String city, String country) {
        Address address = new Address(streetNumber, streetName, zipCode, city, country);
        AddressValidator.of(address).check();
        return address;
    }

    public static Address nullAddress() {
        return new Address(null, null, null, null, null);
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
