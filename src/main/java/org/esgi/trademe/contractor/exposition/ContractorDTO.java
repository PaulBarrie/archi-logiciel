package org.esgi.trademe.contractor.exposition;

import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorAddress;
import org.esgi.trademe.contractor.domain.ContractorCredentials;
import org.esgi.trademe.contractor.domain.Education;

@SuppressWarnings("all")
public final class ContractorDTO {
    private final String lastname;
    private final String firstname;
    private final String email;
    private final ContractorCredentialsDTO credentials;
    private final EducationDTO education;
    private final AddressDTO address;

    public ContractorDTO(String lastname, String firstname, String email, ContractorCredentialsDTO credentials, EducationDTO education, AddressDTO address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.credentials = credentials;
        this.education = education;
        this.address = address;
    }

    public static ContractorDTO of(String lastname, String firstname, String email, ContractorCredentialsDTO credentials, EducationDTO education, AddressDTO address){
        return new ContractorDTO(lastname, firstname, email, credentials, education, address);
    }

    public static ContractorDTO of(Contractor contractor){
        return new ContractorDTO(contractor.getFirstname(), contractor.getLastname(), contractor.getLastname(), ContractorCredentialsDTO.of(contractor.getCredentials().getUsername(),
                contractor.getCredentials().getUsername()), null, AddressDTO.of(contractor.getAddress().getStreetNumber(), contractor.getAddress().getStreetName(),contractor.getAddress().getZipCode(),
                contractor.getAddress().getCity(), contractor.getAddress().getCountry()));
    }
    @Override
    public String toString() {
        return "ContractorDTO{" +
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

    public ContractorCredentialsDTO getCredentials() {
        return credentials;
    }

    public EducationDTO getEducation() {
        return education;
    }

    public AddressDTO getAddress() {
        return address;
    }
}
