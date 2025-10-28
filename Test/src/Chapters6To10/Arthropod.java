package Chapters6To10;

class Arthropod {
    private static String field = "abc";

    protected void printName(long input) {
        System.out.print("Arthropod");
        System.out.println(field);
    }

    void printName(int input) {
        System.out.print("Spooky");
        System.out.println(field);
    }
}
