package org.esgi.trademe.tradesman.exposition;

public final class AddressDTO {
    private final String streetNumber;
    private final String streetName;
    private final String zipCode;
    private final String city;
    private final String country;

    private AddressDTO(String streetNumber, String streetName, String zipCode, String city, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public static AddressDTO of(String streetNumber, String streetName, String zipCode, String city, String country) {
        return new AddressDTO(streetNumber, streetName, zipCode, city, country);
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "streetNumber='" + streetNumber + '\'' +
                "streetName='" + streetName + '\'' +
                "zipCode='" + zipCode + '\'' +
                "city='" + city + '\'' +
                "country='" + country + '\'' +
                '}';
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
