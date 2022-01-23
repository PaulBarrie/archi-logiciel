package org.esgi.trademe.contractor.exposition;


import org.esgi.trademe.contractor.domain.Contractor;
import org.esgi.trademe.contractor.domain.ContractorID;

@SuppressWarnings("all")
public final class ContractorDTO {
    private final ContractorID id;
    private final String lastname;
    private final String firstname;
    private final String email;
    private final String birth;
    private final ContractorCredentialsDTO credentials;
    private final ContractorAddressDTO address;

    public ContractorDTO(ContractorID id, String lastname, String firstname, String email, String birth, ContractorCredentialsDTO credentials, ContractorAddressDTO address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.birth = birth;
        this.credentials = credentials;
        this.address = address;
    }

    public static ContractorDTO of(ContractorID id, String lastname, String firstname, String email, String birth, ContractorCredentialsDTO credentials, ContractorAddressDTO address){
        return new ContractorDTO(id, lastname, firstname, email, birth, credentials, address);
    }

    public static ContractorDTO of(Contractor contractor){
        return new ContractorDTO(contractor.getId(), contractor.getLastname(), contractor.getFirstname(), contractor.getEmail(), contractor.getBirth(),
                ContractorCredentialsDTO.of(contractor.getCredentials().getUsername(), contractor.getCredentials().getPassword()),
                ContractorAddressDTO.of(contractor.getAddress().getStreetNumber(),contractor.getAddress().getStreetName(), contractor.getAddress().getZipCode(),
                        contractor.getAddress().getCity(), contractor.getAddress().getCountry()));
    }

    @Override
    public String toString() {
        return "ContractorDTO{" +
                "id=" + id  +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", birth='" + birth + '\'' +
                ", credentials='" + credentials + '\'' +
                ", address=" + address +
                '}';
    }

    public ContractorID getId() {
        return id;
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

    public String getBirth() {
        return birth;
    }

    public ContractorCredentialsDTO getCredentials() {
        return credentials;
    }

    public ContractorAddressDTO getAddress() {
        return address;
    }
}
