package esgi.barrie.cc1.model.user;

import esgi.barrie.cc1.model.validators.user.AddressValidator;

import java.util.Objects;

public class Address {
    private final String streetNumber;
    private final String streetName;
    private final String zipCode;
    private final String city;
    private final String country;

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

    public String getStreetName() {
        return streetName;
    }

    public String getZipCode() {
        return zipCode;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

}
