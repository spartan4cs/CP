import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;

public class CalculateDOB {
    public static void main(String[] args) throws ParseException {
        // using Calendar Object
        String s = "1989/09/10";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
        Date d = sdf.parse(s);
        Calendar c = Calendar.getInstance();
        c.setTime(d);

        LocalDate birthdDate = LocalDate.of(c.get(Calendar.YEAR), c.get(Calendar.MONTH) + 1, c.get(Calendar.DATE));
        LocalDate today = LocalDate.now();
        Period currentAge = Period.between(birthdDate, today);
        System.out.println("currentAge:" + currentAge.getYears() + "years");
        int retirementAge = 50;
        System.out.println("difference  ("+retirementAge+") -("+currentAge.getYears()+") = " + (retirementAge - currentAge.getYears()));
        int yearleft = retirementAge - currentAge.getYears() + today.getYear();
        System.out.println("retirement tdp " + yearleft);
    }
}

