package Chapters6To10;

public class Flamingo {
    private String color = null;
    public static final Integer num;
    static{
        num = 0;
    }
    public Flamingo()
    {
        //num = 8;
    }
    public void setColor(String color) {
        //color = color;        // line 12 print null
        this.color = color;     // line 12 print PINK
    }
    public static void main(String... unused) {
        var f = new Flamingo();
        f.setColor("PINK");
        System.out.print(f.color);
    }
}