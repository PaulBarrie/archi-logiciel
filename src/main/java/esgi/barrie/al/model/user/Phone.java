package esgi.barrie.cc1.model.user;

import esgi.barrie.cc1.model.validators.user.PhoneValidator;

import java.util.Objects;

public class Phone {

    private final int countryCode;
    private final String number;

    private Phone(int countryCode, String number) {
        this.countryCode = Objects.requireNonNull(countryCode);
        this.number = Objects.requireNonNull(number);
    }

    public static Phone of(int countryCode, String number) {
        Phone phone = new Phone(countryCode, number);
        PhoneValidator.of(phone).check();
        return phone;
    }

    public static Phone nullPhone() {
        return new Phone(-1, null);
    }

    public int getCountryCode() {
        return countryCode;
    }

    public String getNumber() {
        return number;
    }
}