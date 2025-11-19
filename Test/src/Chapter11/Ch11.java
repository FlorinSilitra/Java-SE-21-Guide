package Chapter11;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Ch11 {

    public static void main(String[] args)
    {
        LocalDate date = LocalDate.of(2025, Month.OCTOBER, 20);
        LocalTime time = LocalTime.of(11, 12, 34);
        LocalDateTime dt = LocalDateTime.of(date, time);

        System.out.println(date);
        System.out.println(date.format(DateTimeFormatter.ISO_LOCAL_DATE));

        System.out.println(time);
        System.out.println(time.format(DateTimeFormatter.ISO_LOCAL_TIME));

        System.out.println(dt);
        System.out.println(dt.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println();

        var f = DateTimeFormatter.ofPattern("MMMM dd, yyyy 'at' hh:mm");
        System.out.println(dt.format(f));  // October 20, 2025 at 11:12

        var f1 = DateTimeFormatter.ofPattern("MMM dd, yyyy 'at' hh:mm");
        System.out.println(dt.format(f1));  // October 20, 2025 at 11:12

        var g1 = DateTimeFormatter.ofPattern("MMMM dd', Party''s at' hh:mm");
        System.out.println(dt.format(g1));  // October 20, Party’s at 06:15

        var g2 = DateTimeFormatter.ofPattern("'System format, hh:mm: 'hh:mm");
        System.out.println(dt.format(g2));  // System format, hh:mm: 06:15

        var g3 = DateTimeFormatter.ofPattern("'NEW! 'yyyy', yay!'");
        System.out.println(dt.format(g3));  // NEW! 2025, yay!
        System.out.println();

        Locale locale = Locale.getDefault();
        System.out.println(locale);

        Locale localeNew = Locale.of("fr");
        Locale.setDefault(localeNew);
        System.out.println(Locale.getDefault());  // fr
        System.out.println();

        var huey = (String)null;
        System.out.println(huey);
    }

}
