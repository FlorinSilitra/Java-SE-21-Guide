package Chapters6To10;

import java.util.*;
import java.util.ArrayList;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Ch10 {

    public static void main(String[] args) {
        var numbers = new ArrayList<>();
        var letters = new ArrayList<>();
        numbers.add(1);
        letters.add('a');
        letters.add('b');

        Stream<List<?>> bad = Stream.of(numbers, letters);
        bad.map(List::size)
                .peek(System.out::println)
                .forEach((x) -> System.out.println("Mesaj" + x));


        var random = DoubleStream.generate(Math::random);
        var fractions = DoubleStream.iterate(.5, d -> d / 2);
        random.limit(3).forEach(System.out::println);
        fractions.limit(3).forEach(System.out::println);


        List<Integer> ls = Arrays.asList(1, 2, 3);
        Function<Integer, Integer> func = a -> a * a; //1
        ls
                .stream()
                .map(func)
                .peek(System.out::println)
                .forEach(x -> System.out.println(x)); //2

        var ohMy = Stream.of("bears", "lions", "tigers");
        Map<Integer, String> map = ohMy.collect(Collectors.toMap(
                String::length,
                k -> k,
                (s1, s2) -> s1 + "," + s2,
                TreeMap::new));
        System.out.println(map);            // {5=bears,lions, 6=tigers}
        System.out.println(map.getClass()); // class java.util.TreeMap


        var ohMy2 = Stream.of("lions", "tigers", "tigers", "bears");
        Map<Integer, Set<String>> map2 = ohMy2.collect(
                Collectors.groupingBy(
                        String::length,
                        Collectors.toSet()));
        System.out.println(map2);    // {5=[lions, bears], 6=[tigers]}
        System.out.println();


        var stream = List.of("bird-", "bunny-", "cat-", "dog-", "fish-", "lamb-",
                "mouse-");

        Spliterator<String> originalBagOfFood = stream.spliterator();
        Spliterator<String> emmasBag = originalBagOfFood.trySplit();

        emmasBag.forEachRemaining(System.out::print);          // bird-bunny-cat-
        System.out.println();

        //originalBagOfFood.forEachRemaining(System.out::print); // dog-fish-lamb-mouse-
        //System.out.println();

        Spliterator<String> jillsBag = originalBagOfFood.trySplit();

        jillsBag.tryAdvance(System.out::print);                // dog-
        System.out.println();

        jillsBag.forEachRemaining(System.out::print);          // fish-
        System.out.println();

        originalBagOfFood.forEachRemaining(System.out::print); // lamb-mouse-
        System.out.println();


        var s = DoubleStream.of(1.2, 2.4);
        System.out.println(s.peek(System.out::println).filter(x -> x> 2).count());
        System.out.println();



    }
}
