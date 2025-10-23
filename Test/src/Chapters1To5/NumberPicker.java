package Chapters1To5;

import java.util.Random;

public class NumberPicker {

    void printType(Object o) {
        if (o instanceof Integer bat) {
            System.out.print("int");
        } else if (o instanceof Integer bat && bat < 10) {
            System.out.print("small int");
        } else if (o instanceof Long bat && bat <= 20) {
            System.out.print("long");
        }
    }

    public static void main(String[] args) {

        Random r = new Random();   // DOES NOT COMPILE
        System.out.println(r.nextInt(10));
        System.out.println(r.nextInt(10));

        var num1 = Integer.parseInt("11");
        var num2 = Integer.valueOf("B", 16);
        System.out.println(Integer.max(num1, num2));
        System.out.println(num2);

        int number = 5;
        int negated = ~number;
        System.out.println(negated);   // -6
        System.out.println(~negated);


        int b = 4;
        System.out.println(b = b++);

        int var = 10;
    }
}