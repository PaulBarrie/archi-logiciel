package org.esgi.trademe.tradesman.exposition;

import org.esgi.trademe.tradesman.domain.Tradesman;
import org.esgi.trademe.tradesman.domain.TradesmanID;

@SuppressWarnings("all")
public final class TradesmanDTO {
    private final TradesmanID tradesmanID; 
    private final String lastname;
    private final String firstname;
    private final String email;
    private final TradesmanCredentialsDTO credentials;
    private final EducationDTO education;
    private final AddressDTO address;

    public TradesmanDTO(TradesmanID tradesmanID, String lastname, String firstname, String email, TradesmanCredentialsDTO credentials, EducationDTO education, AddressDTO address) {
        this.tradesmanID = tradesmanID;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.credentials = credentials;
        this.education = education;
        this.address = address;
    }

    public static TradesmanDTO of(TradesmanID tradesmanID,String lastname, String firstname, String email, TradesmanCredentialsDTO credentials, EducationDTO education, AddressDTO address){
        return new TradesmanDTO(tradesmanID, lastname, firstname, email, credentials, education, address);
    }

    public static TradesmanDTO of(Tradesman tradesman){
        return new TradesmanDTO( tradesman.getId(), tradesman.getFirstname(), tradesman.getLastname(), tradesman.getEmail(), TradesmanCredentialsDTO.of(tradesman.getCredentials().getUsername(),
                tradesman.getCredentials().getPassword()), null, AddressDTO.of(tradesman.getAddress().getStreetNumber(), tradesman.getAddress().getStreetName(),tradesman.getAddress().getZipCode(),
                tradesman.getAddress().getCity(), tradesman.getAddress().getCountry()));
    }
    @Override
    public String toString() {
        return "TradesmanDTO{" +
                "id=" + tradesmanID +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", credentials='" + credentials + '\'' +
                ", education='" + education + '\'' +
                ", address=" + address + '\'' +
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
