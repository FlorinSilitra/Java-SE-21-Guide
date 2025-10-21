import java.time.temporal.ChronoUnit;
import java.util.Arrays;
import java.time.*;
import java.util.Random;

public class Chapter4 {
    public static void main(String[] args) {
        var name = "animals";
        System.out.println(name.toUpperCase());    // ANIMALS
        System.out.println(name);

        String text = " abc\t ";
        System.out.println(text.trim().length());          // 3
        System.out.println(text.strip().length());         // 3
        System.out.println(text.stripLeading().length());  // 5
        System.out.println(text.stripTrailing().length()); // 4

        var sb = new StringBuilder("animals");
        sb.insert(7, "-");                   // sb = animals-
        sb.insert(0, "-");                   // sb = -animals-
        sb.insert(4, "ABC");                   // sb = -aniABCmals-
        System.out.println(sb);

        var name1 = "Hello World";
        var name2 = new String("Hello World").intern();
        System.out.println(name1 == name2);     // true

        name1 = name1.toUpperCase();
        System.out.println(name1);              // HELLO WORLD
        System.out.println(name2);              // Hello World
        System.out.println(name1 == name2);     // false

        String[] bugs = { "cricket", "beetle", "ladybug" };
        System.out.println(bugs.toString());           // [Ljava.lang.String;@160bc7c0

        int[] numbers = { 6, 9, 1 };
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length; i++)
            System.out.print(numbers[i] +  " ");

        System.out.println("\n" + numbers);
        System.out.println(Arrays.toString(numbers));

        double amountInCents1 = 64.1 * 100;
        System.out.println(amountInCents1);  // 6409.999999999999

        System.out.println(LocalDate.now());
        System.out.println(LocalTime.now());
        System.out.println(LocalDateTime.now());
        System.out.println(ZonedDateTime.now());

        var date = LocalDate.of(2025, Month.JANUARY, 20);
        System.out.println(date);    // 2025–01–20

        date = date.plusDays(2);
        System.out.println(date);    // 2025–01–22

        date = date.plusWeeks(1);
        System.out.println(date);    // 2025–01–29

        date = date.plusWeeks(1);
        System.out.println(date);


        var date1 = LocalDate.of(2025, Month.JANUARY, 20);
        var time1 = LocalTime.of(5, 15, 20);
        var dateTime = LocalDateTime.of(date1, time1);
        System.out.println(dateTime);

        dateTime = dateTime.minusSeconds(20);
        System.out.println(dateTime);


        var one = LocalTime.of(5, 15);
        var two = LocalTime.of(6, 55);
        var date2 = LocalDate.of(2025, 1, 20);
        System.out.println(ChronoUnit.HOURS.between(one, two));     // 1
        System.out.println(ChronoUnit.MINUTES.between(one, two));   // 100
        //System.out.println(ChronoUnit.MINUTES.between(one, date2));  // DateTimeException

        var period = Period.ofDays(1);
        var days = Duration.ofDays(1);
        System.out.println(period);
        System.out.println(days);

        final int rest;
        if(one == two){
            rest = 5;
            //rest = 8;
        } else rest = 20;

        int one1 = Math.min(5, 3);
        long two2 = Math.round(5.5);
        double three = Math.floor(6.6);
        var doubles = new double[] {one1, two2, three};

        System.out.println(Arrays.toString(doubles));

        var date4 = LocalDate.of(2025, Month.APRIL, 30);
        date4.plusDays(2);
        date4.plusYears(3);
        System.out.println(date4.getYear() + " " + date4.getMonth()
                + " " + date4.getDayOfMonth());
    }
}
