import java.lang.*;
import java.util.*;

public class Main {
    public static <TypeKey> void main(String[] args) {
        HashMap<String, Integer> players = new HashMap<>();
        players.put("Sterling", 10);
        players.put("Rashford", 11);
        players.put("Sancho", 7);
        players.put("Saka", 25);

        System.out.println("Unsorted: ");
        Set set = players.entrySet();
        for (Object o : set) {
            Map.Entry map = (Map.Entry) o;
            System.out.println("Name:  " + map.getKey() + "     Number:   " + map.getValue());
        }
        HashMap map = sortValues(players);
        System.out.println("\n");

        System.out.println("After Sorting by Squad Number:");
        Set set2 = map.entrySet();
        for (Object o : set2) {
            Map.Entry me2 = (Map.Entry) o;
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
