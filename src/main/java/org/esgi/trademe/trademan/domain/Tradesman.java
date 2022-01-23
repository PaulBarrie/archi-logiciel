package org.esgi.trademe.trademan.domain;



import org.esgi.trademe.kernel.Entity;

import java.util.Objects;

public final class Tradesman implements Entity<TradesmanID> {
    private final TradesmanID id;
    private final String lastname;
    private final String firstname;
    private final String email;
    private final TradesmanCredentials credentials;
    private  Education education;
    private TradesmanAddress address;

    private Tradesman(TradesmanID id, String lastname, String firstname, String email, TradesmanCredentials credentials, Education education, TradesmanAddress address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.credentials = credentials;
        this.education = education;
        this.address = address;
    }

    public static Tradesman of(TradesmanID id, String lastname, String firstname, String email, TradesmanCredentials credentials, Education education, TradesmanAddress address) {
        return new Tradesman(id, lastname, firstname, email, credentials, education, address);
    }

    private Tradesman(TradesmanID id, String lastname, String firstname, String email, TradesmanCredentials credentials, TradesmanAddress address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.credentials = credentials;
        this.address = address;
    }

    public static Tradesman of(TradesmanID id, String lastname, String firstname, String email, TradesmanCredentials credentials, TradesmanAddress address) {
        return new Tradesman(id, lastname, firstname, email, credentials, address);
    }

    public TradesmanID getId() {
        return id;
    }

    @Override
    public TradesmanID id() {
        return id;
    }

    public String getLastname() {
        return lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public TradesmanAddress getAddress() {
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

    public void setAddress(TradesmanAddress address) {
        this.address = address;
    }

    public void changeAddress(TradesmanAddress address) {
        this.address = address;
    }

    public TradesmanCredentials getCredentials() {
        return credentials;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tradesman tradesman = (Tradesman) o;
        return Objects.equals(id, tradesman.id) && Objects.equals(lastname, tradesman.lastname) && Objects.equals(firstname, tradesman.firstname) 
                && Objects.equals(address, tradesman.address) && Objects.equals(education, tradesman.education );
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
                ", email='" + email + '\'' +
                ", education='" + education + '\'' +
                ", address=" + address +
                '}';
    }
}
