package org.esgi.trademe.member.exposition;


import org.esgi.trademe.member.domain.Member;
import org.esgi.trademe.member.domain.MemberID;

@SuppressWarnings("all")
public class MemberDTO {
    private final MemberID id;
    private final String lastname;
    private final String firstname;
    private final String email;
    private final String birth;
    private final MemberCredentialsDTO credentials;
    private final MemberAddressDTO address;

    public MemberDTO(MemberID id, String lastname, String firstname, String email, String birth, MemberCredentialsDTO credentials, MemberAddressDTO address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.birth = birth;
        this.credentials = credentials;
        this.address = address;
    }

    public static MemberDTO of(MemberID id, String lastname, String firstname, String email, String birth, MemberCredentialsDTO credentials, MemberAddressDTO address){
        return new MemberDTO(id, lastname, firstname, email, birth, credentials, address);
    }

    public static MemberDTO of(Member member){
        return new MemberDTO(member.getId(), member.getLastname(), member.getFirstname(), member.getEmail(), member.getBirth(),
                MemberCredentialsDTO.of(member.getCredentials().getUsername(), member.getCredentials().getPassword()),
                MemberAddressDTO.of(member.getAddress().getStreetNumber(),member.getAddress().getStreetName(), member.getAddress().getZipCode(),
                        member.getAddress().getCity(), member.getAddress().getCountry()));
    }

    @Override
    public String toString() {
        return "MemberDTO{" +
                "id=" + id  +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", birth='" + birth + '\'' +
                ", credentials='" + credentials + '\'' +
                ", address=" + address +
                '}';
    }

    public MemberID getId() {
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

    public MemberCredentialsDTO getCredentials() {
        return credentials;
    }

    public MemberAddressDTO getAddress() {
        return address;
    }
}
