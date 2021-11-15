package esgi.barrie.al.model.validators.user;

import esgi.barrie.al.model.user.Address;

public final class AddressValidator {
    private final Address address;

    private AddressValidator(Address address) {
        this.address = address;
    }

    public static AddressValidator of(Address address) {
        return new AddressValidator(address);
    }

    public void check() throws IllegalArgumentException {
        //Check street number under French format
        if(!this.address.getStreetNumber().matches("^\\d{1,4}(?:[a-zA-z]{1,2}\\d{0,3})?$")) {
            throw new IllegalArgumentException("Invalid street number.");
        }
        //Check street name: check no symbol
        if(!this.address.getStreetName().matches("^[_A-z0-9]*((-|\\s)*[_A-z0-9])*$")) {
            throw new IllegalArgumentException("Invalid street name.");
        }
        //Check zip code (French only)
        if(!this.address.getZipCode().matches("^((0[1-9])|([1-8][0-9])|(9[0-8])|(2A)|(2B))[0-9]{3}$")) {
            throw new IllegalArgumentException("Invalid zip code.");
        }
        String regexName = "^[^±!@£$%^&*_+§¡€#¢§¶•ªº«\\\\/<>?:;|=.,]{1,20}$";
        //Check city
        if(!this.address.getCity().matches(regexName)) {
            throw new IllegalArgumentException("Invalid city.");
        }
        //Check country
        if(!this.address.getCountry().matches(regexName)) {
            throw new IllegalArgumentException("Invalid city.");
        }
    }
}
