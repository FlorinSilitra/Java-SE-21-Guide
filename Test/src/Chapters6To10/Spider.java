package Chapters6To10;

public class Spider extends Arthropod {
    private static String field = "abd";

    protected void printName(int input) {
        System.out.print("Spider");
        System.out.println(field);
    }

    public static void main(String[] args) {
        Spider a = new Spider();
        a.printName((short) 4);
        a.printName(4);
        a.printName(5L);
        System.out.println(a.field);
    }
}