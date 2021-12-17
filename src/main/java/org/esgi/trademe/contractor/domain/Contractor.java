package org.esgi.trademe.contractor.domain;



import org.esgi.trademe.kernel.Entity;

import java.util.Objects;

public final class Contractor implements Entity<ContractorID> {
    private final ContractorID id;
    private final String lastname;
    private final String firstname;
    private final String email;
    private final ContractorCredentials credentials;
    private  Education education;
    private ContractorAddress address;

    private Contractor(ContractorID id, String lastname, String firstname, String email, ContractorCredentials credentials, Education education, ContractorAddress address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.credentials = credentials;
        this.education = education;
        this.address = address;
    }

    public static Contractor of(ContractorID id, String lastname, String firstname, String email, ContractorCredentials credentials, Education education, ContractorAddress address) {
        return new Contractor(id, lastname, firstname, email, credentials, education, address);
    }

    private Contractor(ContractorID id, String lastname, String firstname, String email, ContractorCredentials credentials, ContractorAddress address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.credentials = credentials;
        this.address = address;
    }

    public static Contractor of(ContractorID id, String lastname, String firstname, String email, ContractorCredentials credentials, ContractorAddress address) {
        return new Contractor(id, lastname, firstname, email, credentials, address);
    }

    public ContractorID getId() {
        return id;
    }

    @Override
    public ContractorID id() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public ContractorAddress getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    public void setAddress(ContractorAddress address) {
        this.address = address;
    }

    public void changeAddress(ContractorAddress address) {
        this.address = address;
    }

    public ContractorCredentials getCredentials() {
        return credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contractor contractor = (Contractor) o;
        return Objects.equals(id, contractor.id) && Objects.equals(lastname, contractor.lastname) && Objects.equals(firstname, contractor.firstname) 
                && Objects.equals(address, contractor.address) && Objects.equals(education, contractor.education );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, address);
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", address=" + address +
                '}';
    }
}
