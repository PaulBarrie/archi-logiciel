package org.esgi.trademe.tradesman.application.create;


import org.esgi.trademe.tradesman.exposition.AddressDTO;
import org.esgi.trademe.tradesman.exposition.TradesmanCredentialsDTO;
import org.esgi.trademe.kernel.command.Command;

/**
 * Command object
 */
@SuppressWarnings("all")
public final class CreateTradesman implements Command {
    public final String lastname;
    public final String firstname;
    public final String email;
    public final TradesmanCredentialsDTO credentials;
    public final AddressDTO address;

    private CreateTradesman(String lastname, String firstname, String email, TradesmanCredentialsDTO credentials, AddressDTO address) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.email = email;
        this.credentials = credentials;
        this.address = address;
    }

    public static CreateTradesman of(String lastname, String firstname, String email, TradesmanCredentialsDTO credentials, AddressDTO address) {
        return new CreateTradesman(lastname, firstname, email, credentials, address);
    }
}
