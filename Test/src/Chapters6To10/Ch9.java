package Chapters6To10;

import java.util.ArrayList;
import java.util.List;

import java.util.*;
import java.util.stream.Stream;

public class Ch9 {
    private static int count = 20;
    public void incrementCountBadly() {
        Stream.iterate(0, n -> n + 1)
                .limit(10)
                .forEach(p -> count++);
    }

    static void addElementsAndPrint(Map<String, String> map) {
        map.put("koala", "bamboo");
        map.put("lion", "meat");
        map.put("giraffe", "leaf");
        String food = map.get("koala"); // bamboo
        for (String key: map.keySet())
            System.out.print(key + ",");
        System.out.println();
    }

    public static void welcomeNext(SequencedMap<String, String> visitors) {
        System.out.println("Welcome to the Zoo! " + visitors.pollFirstEntry());
    }

    public static void main(String[] args)
    {
        List<String> list = new ArrayList<>();
        list.add("hawk");
        list.add("robin");

        Object[] objectArray = list.toArray();
        String[] stringArray1 = list.toArray(new String[0]);
        String[] stringArray2 = list.toArray(new String[3]);
        list.clear();

        System.out.println(objectArray.length);         // 2
        System.out.println(stringArray1.length);        // 2
        System.out.println(stringArray2.length);        // 2


        addElementsAndPrint(new HashMap<>());        // koala,giraffe,lion,
        addElementsAndPrint(new LinkedHashMap<>());  // koala,lion,giraffe,
        addElementsAndPrint(new TreeMap<>());        // giraffe,koala,lion,


        var visitTreeMap = new TreeMap<String,String>(
                Map.of("Pink", "Blossom", "Green", "Buttercup", "Blue", "Bubbles"));
        welcomeNext(visitTreeMap);

        List<Integer>q = new LinkedList<>();
        var u = Collections.unmodifiableCollection(q);
        q.add(10);
        q.add(12);
        q.remove(1);
        System.out.print(u);

        Map m = new HashMap();
        m.put(123, "456");
        m.put("abc", "def");
        System.out.println(m);
        System.out.println(m.containsKey("123"));

        SequencedCollection<String> animals = new ArrayDeque<>();
        animals.addFirst("lions");
        animals.addLast("tigers");
        for(var a : animals)
           System.out.println(a);

        Ch9 ch9 = new Ch9();

        System.out.println(count);
        ch9.incrementCountBadly();
        System.out.println(count);
    }
}
