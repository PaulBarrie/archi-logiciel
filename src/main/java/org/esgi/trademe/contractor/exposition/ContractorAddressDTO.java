package org.esgi.trademe.contractor.exposition;

public final class ContractorAddressDTO {
    private final String streetNumber;
    private final String streetName;
    private final String zipCode;
    private final String city;
    private final String country;

    private ContractorAddressDTO(String streetNumber, String streetName, String zipCode, String city, String country) {
        this.streetNumber = streetNumber;
        this.streetName = streetName;
        this.zipCode = zipCode;
        this.city = city;
        this.country = country;
    }

    public static ContractorAddressDTO of(String streetNumber, String streetName, String zipCode, String city, String country) {
        return new ContractorAddressDTO(streetNumber, streetName, zipCode, city, country);
    }

    @Override
    public String toString() {
        return "AddressDTO{" +
                "street_number=" + streetNumber +
                ", street_name='" + streetName + '\'' +
                ", zip_code='" + zipCode + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
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
