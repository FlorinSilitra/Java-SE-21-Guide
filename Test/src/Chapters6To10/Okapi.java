package Chapters6To10;

public class Okapi extends GiraffeFamily {
    static {
        System.out.print("F");
    }

    {
        System.out.print("H");
    }

    public Okapi(int stripes) {
        super("sugar");
        System.out.print("G");
    }



    public static void main(String[] grass) {
        new Okapi(1);
        System.out.println();
        new Okapi(2);
    }
}