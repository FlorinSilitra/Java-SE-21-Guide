package Chapter14;

import java.nio.file.Path;

public class Ch14 {
    public static void main(String[] args)
    {
        Path path = Path.of("/land/hippo/harry.happy");
        System.out.println("The Path is: " + path);
        for(int i=0; i<path.getNameCount(); i++)
            System.out.println("   Element " + i + " is: " + path.getName(i));
    }
}
