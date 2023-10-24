import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static <TypeKey> void main(String[] args) {
        HashMap<String, Integer> players = new HashMap<>();
        players.put("Sterling", 10);
        players.put("Rashford", 11);
        players.put("Sancho", 7);

//        players.put(new Player("Saka", 25), 25);
//        players.put(new Player("Rashford", 11), 11);
//        players.put(new Player("Sancho", 7), 7);
//        players.put(new Player("Sterling", 10), 10);

//        System.out.println("Unsorted: ");
//        System.out.println(players);
//
//        Collections.sort(List<players>, new NumSort());
//
//        System.out.println("Sorted by Player Number: ");
//        System.out.println(players);
//
////        Collections.sort(players, new NameSort());
//
//        System.out.println("Sorted by Player Name: ");
//        System.out.println(players);

        Set set = players.entrySet();
        Iterator iterator = set.iterator();
        while (iterator.hasNext()) {
            Map.Entry map = (Map.Entry) iterator.next();
            System.out.println("Name:  " + map.getKey() + "     Number:   " + map.getValue());
        }
        Map<Integer, String> map = sortValues(players);
        System.out.println("\n");
        System.out.println("After Sorting by Squad Number:");
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        while (iterator2.hasNext()) {
            Map.Entry me2 = (Map.Entry) iterator2.next();
            System.out.println("Name:  " + me2.getKey() + "     Number:   " + me2.getValue());
        }
    }

    //method to sort values
    private static HashMap sortValues(HashMap map) {
        List list = new LinkedList(map.entrySet());
//Custom Comparator
        Collections.sort(list, new Comparator() {
            public int compare(Object o1, Object o2) {
                return ((Comparable) ((Map.Entry) (o1)).getValue()).compareTo(((Map.Entry) (o2)).getValue());
            }
        });
//copying the sorted list in HashMap to preserve the iteration order
        HashMap sortedHashMap = new LinkedHashMap();
        for (Iterator it = list.iterator(); it.hasNext(); ) {
            Map.Entry entry = (Map.Entry) it.next();
            sortedHashMap.put(entry.getKey(), entry.getValue());
        }
        return sortedHashMap;
    }
}
