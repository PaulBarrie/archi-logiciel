package esgi.barrie.al.model.validators.user;

import esgi.barrie.al.model.user.Phone;

import java.util.Objects;

public final class PhoneValidator {
    private final Phone phone;

    private PhoneValidator(Phone phone) {
        this.phone = Objects.requireNonNull(phone);
    }

    public static  PhoneValidator of(Phone phone) {
        return new PhoneValidator(phone);
    }

    public void check() throws IllegalArgumentException{
        //Does not take into account special codes and unassgned codes
        if (this.phone.getCountryCode() > 999 && this.phone.getCountryCode() < 0) {
            throw new IllegalArgumentException("Invalid phone country code.");
        }
        //Check if phone number contains only digits
        if(!this.phone.getNumber().matches("\\d+")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
    }
}
