package Chapter14;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Gorilla implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int age;
    private Boolean friendly;
    private transient String favoriteFood;

    public Gorilla(String name, int age, Boolean friendly) {
        this.name = name;
        this.age = age;
        this.friendly = friendly;
    }

    @Override
    public String toString() {
        return "Gorilla{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", friendly=" + friendly +
                ", favoriteFood='" + favoriteFood + '\'' +
                '}';
    }

    static void saveToFile(List<Gorilla> gorillas, File dataFile) throws IOException {
        try (var out = new ObjectOutputStream(
                        new BufferedOutputStream(
                        new FileOutputStream(dataFile)))) {

            for (Gorilla gorilla : gorillas)
                out.writeObject(gorilla);
        }
    }

    static List<Gorilla> readFromFile(File dataFile) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();

        try (var in = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(dataFile)))) {
            while (true) {
                var object = in.readObject();
                if (object instanceof Gorilla g)
                    gorillas.add(g);
            }
        } catch (EOFException e) {
            // File end reached
        }
        return gorillas;
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        var gorillas = new ArrayList<Gorilla>();
        gorillas.add(new Gorilla("Grodd", 5, false));
        gorillas.add(new Gorilla("Ishmael", 8, true));
        File dataFile = new File("gorilla.ser");

        saveToFile(gorillas, dataFile);
        var gorillasFromDisk = readFromFile(dataFile);

        for (Gorilla gorilla : gorillasFromDisk)
            System.out.println(gorilla);
    }
}