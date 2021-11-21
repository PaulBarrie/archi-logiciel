package membership.handler.validator.user;


import membership.common.user.User;
import membership.handler.validator.date.BirthDateValidator;
import membership.handler.validator.date.DateValidator;

public class UserValidator {
    private final User user;

    private UserValidator(User user) {
        this.user = user;
    }

    public static UserValidator of(User user) {
        return new UserValidator(user);
    }

    public String isValid() {
        String regexName = "^[^±!@£$%^&*_+§¡€#¢§¶•ªº«\\\\/<>?:;|=.,]{1,20}$";
        //Check firstname
        if(!this.user.getFirstName().matches(regexName)) {
            return "Invalid firstname.";
        }
        //Check lastname
        if(!this.user.getLastName().matches(regexName)) {
            throw new IllegalArgumentException("Invalid Lastname.");
        }
        // Check email
        String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        if(!this.user.getEmail().matches(emailRegex)) {
            return "Invalid Email.";
        }
        //Check birth
        DateValidator validator = new BirthDateValidator("dd/MM/yyyy");
        return validator.isValid(this.user.getBirth());
    }

}
