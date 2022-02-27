package org.esgi.trademe.contractor.validation.validator.date;

import org.esgi.trademe.kernel.validator.DateValidator;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public final class ContractorBirthDateValidator implements DateValidator {
    private final String dateFormat;

    public ContractorBirthDateValidator(String dateFormat) {
        this.dateFormat = dateFormat;
    }


    @Override
    public String isValid(String dateStr) {
        Calendar cal = null;
        try {
            DateFormat sdf = new SimpleDateFormat(this.dateFormat);
            sdf.setLenient(false);
            Date date = sdf.parse(dateStr);
            cal = Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.YEAR, 18);
            if (cal.after(new Date())) {
                return "Must be at least 18.";
            }
        } catch (ParseException e) {
            return "Invalid date format.";
        }
        return null;
    }
}
