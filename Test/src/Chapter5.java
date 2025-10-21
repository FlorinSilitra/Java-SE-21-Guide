import java.util.Arrays;

public class Chapter5 {

    public static class Dog1 {
        public static void main() {
            var name = new StringBuilder("Webby");
            speak(name);
            System.out.print(name);   // WebbyGeorgette
        }
        public static void speak(StringBuilder s) {
            s.append("Georgette");
        }
    }

    public static class Dog2 {
        public static void main() {
            var name = new String("Webby");
            speak(name);
            System.out.print(name);   // WebbyGeorgette
        }
        public static void speak(String s) {
            s = "Georgette";
        }
    }

    public class BadZooParking {
        public static void main(String[] args) {
            Arrays.asList("one");           // DOES NOT COMPILE
        }
    }

    public class Panda {
        final static String name;
        static final int bamboo;

        //static final double height; // DOES NOT COMPILE
        static {
            bamboo = 5;
        }

        static {
            name = "Ronda";
        }
    }

    public static class Penguin {
        String name;
        static String nameOfTallestPenguin;
    }

    public static void main(String[] args) {
        var p1 = new Penguin();
        p1.name = "Lilly";
        Penguin.nameOfTallestPenguin = "Lilly";
        var p2 = new Penguin();
        p2.name = "Willy";
        Penguin.nameOfTallestPenguin = "Willy";

        System.out.println(p1.name);                  // Lilly
        System.out.println(Penguin.nameOfTallestPenguin);  // Willy
        System.out.println(p2.name);                  // Willy
        System.out.println(Penguin.nameOfTallestPenguin);  // Willy

        p1 = null; // p1 is still a penguin, even if he points to null reference
        System.out.println(p1.nameOfTallestPenguin);

        Character elephant = null;
        //char badElephant = elephant;   // NullPointerException
        //char sameElephant = null;     // Does not compile

        Dog1.main();
        System.out.println();
        Dog2.main();
    }
}
