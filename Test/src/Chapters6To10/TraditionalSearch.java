package Chapters6To10;

import java.time.LocalDate;
import java.util.*;
import java.util.function.Supplier;

public class TraditionalSearch {
    public static void main(String[] args) {

        // list of animals
        var animals = new ArrayList<Animal2>();
        animals.add(new Animal2("fish", false, true));
        animals.add(new Animal2("kangaroo", true, false));
        animals.add(new Animal2("rabbit", true, false));
        animals.add(new Animal2("turtle", false, true));

        print(animals, a -> a.canHop());

        Supplier<LocalDate> s1 = LocalDate::now;
        Supplier<LocalDate> s2 = () -> LocalDate.now();

        LocalDate d1 = s1.get();
        LocalDate d2 = s2.get();
        LocalDate d3 = LocalDate.now();

        System.out.println(d1);  // 2025-02-20
        System.out.println(d2);  // 2025-02-20
        System.out.println(d3);  // 2025-02-20
    }

    private static void print(List<Animal2> animals, CheckTrait checker) {
        for (Animal2 animal : animals) {
            if (checker.test(animal))
                System.out.print(animal.species() + " ");
        }
        System.out.println();
    }
}
