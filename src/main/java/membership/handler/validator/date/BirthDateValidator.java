package membership.handler.validator.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

public class BirthDateValidator implements DateValidator {
    private DateTimeFormatter dateTimeFormatter;

    private final String dateFormat;

    public BirthDateValidator(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    @Override
    public String isValid(String dateStr) {
        Calendar cal=null;
        try {
            DateFormat sdf = new SimpleDateFormat(this.dateFormat);
            sdf.setLenient(false);
            Date date = sdf.parse(dateStr);
            cal =  Calendar.getInstance();
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
