package org.esgi.trademe.member.validation.validator.member;


import org.esgi.trademe.kernel.validator.Validator;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;
import org.esgi.trademe.member.domain.Member;
import org.esgi.trademe.member.validation.validator.date.MemberBirthDateValidator;
import org.esgi.trademe.kernel.validator.DateValidator;


public class MemberValidator implements Validator<Member> {
    public void isValid(Member entity) throws InvalidEntryException {
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
        String emailRegex = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9]))\\.){3}(?:(2(5[0-5]|[0-4][0-9])|1[0-9][0-9]|[1-9]?[0-9])|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
        if (!entity.getEmail().matches(emailRegex)) {
            throw InvalidEntryException.forField("Email", entity.getEmail());
        }
        //Check birth
        DateValidator validator = new MemberBirthDateValidator("dd/MM/yyyy");
        validator.isValid(entity.getBirth());
    }

}
