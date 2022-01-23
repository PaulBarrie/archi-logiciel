package org.esgi.trademe.trademan.exposition;

import org.esgi.trademe.trademan.domain.Tradesman;

@SuppressWarnings("all")
public final class TradesmanDTO {
    private final String lastname;
    private final String firstname;
    private final String email;
    private final TradesmanCredentialsDTO credentials;
    private final EducationDTO education;
    private final AddressDTO address;

    public TradesmanDTO(String lastname, String firstname, String email, TradesmanCredentialsDTO credentials, EducationDTO education, AddressDTO address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.credentials = credentials;
        this.education = education;
        this.address = address;
    }

    public static TradesmanDTO of(String lastname, String firstname, String email, TradesmanCredentialsDTO credentials, EducationDTO education, AddressDTO address){
        return new TradesmanDTO(lastname, firstname, email, credentials, education, address);
    }

    public static TradesmanDTO of(Tradesman tradesman){
        return new TradesmanDTO(tradesman.getFirstname(), tradesman.getLastname(), tradesman.getLastname(), TradesmanCredentialsDTO.of(tradesman.getCredentials().getUsername(),
                tradesman.getCredentials().getUsername()), null, AddressDTO.of(tradesman.getAddress().getStreetNumber(), tradesman.getAddress().getStreetName(),tradesman.getAddress().getZipCode(),
                tradesman.getAddress().getCity(), tradesman.getAddress().getCountry()));
    }
    @Override
    public String toString() {
        return "TradesmanDTO{" +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", credentials='" + credentials + '\'' +
                ", education='" + education + '\'' +
                ", address=" + address +
                '}';
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getEmail() {
        return email;
    }

    public TradesmanCredentialsDTO getCredentials() {
        return credentials;
    }

    public EducationDTO getEducation() {
        return education;
    }

    public AddressDTO getAddress() {
        return address;
    }
}
