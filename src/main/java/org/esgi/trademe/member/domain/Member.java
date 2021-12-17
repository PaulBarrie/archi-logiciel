package org.esgi.trademe.member.domain;



import org.esgi.trademe.kernel.Entity;

import java.util.Objects;

public final class Member implements Entity<MemberID> {
    private final MemberID id;
    private final String lastname;
    private final String firstname;
    private final String email;
    private final String birth;
    private final MemberCredentials credentials;
    private MemberAddress address;

    private Member(MemberID id, String lastname, String firstname, String email, String birth, MemberCredentials credentials, MemberAddress address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.birth = birth;
        this.credentials = credentials;
        this.address = address;
    }

    public static Member of(MemberID id, String lastname, String firstname, String email, String birth, MemberCredentials credentials, MemberAddress address) {
        return new Member(id, lastname, firstname, email, birth, credentials, address);
    }

    public MemberID getId() {
        return id;
    }

    @Override
    public MemberID id() {
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

    public MemberCredentials getCredentials() {
        return credentials;
    }

    public MemberAddress getAddress() {
        return address;
    }

    public void changeAddress(MemberAddress address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id) && Objects.equals(lastname, member.lastname) && Objects.equals(firstname, member.firstname) && Objects.equals(address, member.address);
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
                ", address=" + address +
                '}';
    }
}
