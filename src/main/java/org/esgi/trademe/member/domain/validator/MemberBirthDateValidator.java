package org.esgi.trademe.member.domain.validator;

import org.esgi.trademe.kernel.validator.Validator;
import org.esgi.trademe.kernel.exceptions.InvalidEntryException;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public final class MemberBirthDateValidator implements Validator<String> {
    private final String dateFormat;
    private DateTimeFormatter dateTimeFormatter;

    public MemberBirthDateValidator(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public void isValid(String dateStr) throws InvalidEntryException {
        Calendar cal = null;
        try {
            DateFormat sdf = new SimpleDateFormat(this.dateFormat);
            sdf.setLenient(false);
            Date date = sdf.parse(dateStr);
            cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.YEAR, 18);
            if (cal.after(new Date())) {
                throw new InvalidEntryException("Must be at least 18 to register on.");
            }
        } catch (ParseException e) {
            throw InvalidEntryException.forField("Date", dateStr);
        }
    }
}
