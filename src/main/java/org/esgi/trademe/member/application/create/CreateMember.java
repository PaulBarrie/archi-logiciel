package org.esgi.trademe.member.application.create;


import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.member.exposition.MemberAddressDTO;
import org.esgi.trademe.member.exposition.MemberCredentialsDTO;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateMember implements Command {
    public final String lastname;
    public final String firstname;
    public final String email;
    public final String birth;
    public final MemberCredentialsDTO credentials;
    public final MemberAddressDTO address;

    private CreateMember(String lastname, String firstname, String email, String birth, MemberCredentialsDTO credentials, MemberAddressDTO address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.birth = birth;
        this.credentials = credentials;
        this.address = address;
    }

    public static CreateMember of(String lastname, String firstname, String email, String birth, MemberCredentialsDTO credentials,
                                  MemberAddressDTO address) {
        return new CreateMember(lastname, firstname, email, birth, credentials, address);
    }
}
