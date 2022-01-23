package org.esgi.trademe.contractor.application.create;


import org.esgi.trademe.kernel.command.Command;
import org.esgi.trademe.contractor.exposition.ContractorAddressDTO;
import org.esgi.trademe.contractor.exposition.ContractorCredentialsDTO;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateContractor implements Command {
    public final String lastname;
    public final String firstname;
    public final String email;
    public final String birth;
    public final ContractorCredentialsDTO credentials;
    public final ContractorAddressDTO address;

    private CreateContractor(String lastname, String firstname, String email, String birth, ContractorCredentialsDTO credentials, ContractorAddressDTO address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.birth = birth;
        this.credentials = credentials;
        this.address = address;
    }

    public static CreateContractor of(String lastname, String firstname, String email, String birth, ContractorCredentialsDTO credentials,
                                      ContractorAddressDTO address) {
        return new CreateContractor(lastname, firstname, email, birth, credentials, address);
    }
}
