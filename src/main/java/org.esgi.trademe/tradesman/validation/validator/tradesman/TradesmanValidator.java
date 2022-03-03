package org.esgi.trademe.tradesman.validation.validator.tradesman;


import org.esgi.trademe.tradesman.domain.Tradesman;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.kernel.validator.Validator;

public final class TradesmanValidator implements Validator<Tradesman> {
    public void isValid(Tradesman entity) throws InvalidEntryException {
        String regexName = "^[^±!@£$%^&*_+§¡€#¢§¶•ªº«\\\\/<>?:;|=.,]{1,20}$";
        //Check firstname
        if (!entity.getFirstname().matches(regexName)) {
            throw InvalidEntryException.forField("Firstname", entity.getFirstname());
        }
        //Check lastname
        if (!entity.getLastname().matches(regexName)) {
            throw InvalidEntryException.forField("Lastname", entity.getLastname());
        }
        // Check email
        String emailRegex = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
        if (!entity.getEmail().matches(emailRegex)) {
            System.out.println("INVALIDOO");
            throw InvalidEntryException.forField("Email", entity.getEmail());
        }
    }

}

