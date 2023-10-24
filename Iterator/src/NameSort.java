import java.util.Comparator;

public class NameSort implements Comparator<Player> {
    public int compare(Player a, Player b) {
        return a.name.compareTo(b.name);
    }
}

