package org.esgi.trademe.contractor.application.create;


import org.esgi.trademe.contractor.exposition.AddressDTO;
import org.esgi.trademe.contractor.exposition.ContractorCredentialsDTO;
import org.esgi.trademe.kernel.command.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateContractor implements Command {
    public final String lastname;
    public final String firstname;
    public final String email;
    public final ContractorCredentialsDTO credentials;
    public final AddressDTO address;

    private CreateContractor(String lastname, String firstname, String email, ContractorCredentialsDTO credentials, AddressDTO address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.credentials = credentials;
        this.address = address;
    }

    public static CreateContractor of(String lastname, String firstname, String email, ContractorCredentialsDTO credentials, AddressDTO address) {
        return new CreateContractor(lastname, firstname, email, credentials, address);
    }
}
