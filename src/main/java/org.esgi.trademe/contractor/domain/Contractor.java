package org.esgi.trademe.contractor.domain;



import org.esgi.trademe.kernel.Entity;

import java.util.Objects;

public final class Contractor implements Entity<ContractorID> {
    private final ContractorID id;
    private final String lastname;
    private final String firstname;
    private final String email;
    private final String birth;
    private final ContractorCredentials credentials;
    private ContractorAddress address;

    private Contractor(ContractorID id, String lastname, String firstname, String email, String birth, ContractorCredentials credentials, ContractorAddress address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.birth = birth;
        this.credentials = credentials;
        this.address = address;
    }

    public static Contractor of(ContractorID id, String lastname, String firstname, String email, String birth, ContractorCredentials credentials, ContractorAddress address) {
        return new Contractor(id, lastname, firstname, email, birth, credentials, address);
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

    public String getBirth() {
        return birth;
    }

    public String getEmail() {
        return email;
    }

    public ContractorCredentials getCredentials() {
        return credentials;
    }

    public ContractorAddress getAddress() {
        return address;
    }

    public void changeAddress(ContractorAddress address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contractor contractor = (Contractor) o;
        return Objects.equals(id, contractor.id) && Objects.equals(lastname, contractor.lastname) && Objects.equals(firstname, contractor.firstname) && Objects.equals(address, contractor.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, lastname, firstname, address);
    }

    @Override
    public String toString() {
        return "Contractor{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address=" + address +
                '}';
    }
}
