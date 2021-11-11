package esgi.barrie.al.model.validators.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Calendar;
import java.util.Date;

public class BirthDateValidator implements DateValidator {
    private DateTimeFormatter dateTimeFormatter;

    private final String dateFormat;

    public DateValidatorUsingFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public void check(String dateStr) throws IllegalArgumentException {
        Calendar cal=null;
        try {
            DateFormat sdf = new SimpleDateFormat(this.dateFormat);
            sdf.setLenient(false);
            Date date = sdf.parse(dateStr);
            cal =  Calendar.getInstance();
            cal.setTime(date);
            cal.add(Calendar.YEAR, 18);
            if (cal.after(new Date())) {
                throw new IllegalArgumentException("Must be at least 18.");
            }
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format.");
        }
    }
}
