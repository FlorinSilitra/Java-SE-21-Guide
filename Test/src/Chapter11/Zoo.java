package Chapter11;

import java.util.Locale;
import java.util.ResourceBundle;

public class Zoo {
    public static void printWelcomeMessage(Locale locale) {
        var rb = ResourceBundle.getBundle("Chapters11To13.Zoo", locale);
        System.out.println(rb.getString("hello")
                + ", " + rb.getString("open"));

        rb.keySet().stream()
                .map(k -> k + ": " + rb.getString(k))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        var us = Locale.of("en", "US");
        var france = Locale.of("fr", "FR");
        printWelcomeMessage(us);     // Hello, The zoo is open
        System.out.println();
        printWelcomeMessage(france); // Bonjour, Le zoo est ouvert



    }
}
