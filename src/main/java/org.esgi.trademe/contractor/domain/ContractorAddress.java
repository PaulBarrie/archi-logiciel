package org.esgi.trademe.contractor.domain;

public final class ContractorAddress {

    private final String streetNumber;
    private final String streetName;
    private final String zipCode;
    private final String city;
    private final String country;

    private ContractorAddress(String streetNumber, String streetName, String zipCode, String street, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = street;
        this.country = country;
    }

    public static ContractorAddress of(String streetNumber, String streetName, String zipCode, String street, String country) {
        return new ContractorAddress(streetNumber, streetName, zipCode, street, country);
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

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                '}';
    }
}
